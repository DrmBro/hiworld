var seckill = {
    URL : {
        now : function () {
            return '/seckill/time/now';
        },
        exposer : function (seckillId) {
            return '/seckill/' + seckillId + '/exposer';
        },
        execution : function (seckillId,md5) {
            return '/seckill/' + seckillId + '/' + md5 + '/execution';
        }
    },

    handleSeckill: function(seckillId,node){
        node.hide()
            .html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
        $.post(seckill.URL.exposer(seckillId),{},function (result) {
            if(result && result['success']){
                var exposer =result['data'];
                if(exposer['exposed']){
                    var md5 = exposer['md5'];
                    var killUrl = seckill.URL.execution(seckillId,md5);

                    $('#killBtn').one('click',function () {
                        $(this).addClass('disable');
                        $.post(killUrl,{},function (result) {
                            if(result && result['success']){
                                var killResult = result['data'];
                                var state = killResult['state'];
                                var stateInfo = killResult['stateInfo'];
                                node.html('<span class="label label-success">' + stateInfo + '</span>')

                            }
                        });
                    });
                    node.show();
                } else{
                    var now = exposer['now'];
                    var start = exposer['start'];
                    var end = exposer['end'];
                    seckill.countdown(seckillId,now,start,end);
                }
            } else {

            }
        })
    },

    validatePhone: function(phone){
        if(phone && phone.length == 11 && !isNaN(phone)){
            return true;
        } else {
            return false;
        }
    },

    countdown: function(seckillId,nowTime,startTime,endTime){
        var seckillBox = $('#seckill-box');
        if(nowTime > endTime){
            seckillBox.html('秒杀结束!');
        } else if(nowTime < startTime){

            var killTime = new Date(startTime + 1000);
            seckillBox.countdown(killTime,function (event) {
                var format = event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒');
                seckillBox.html(format);
            }).on('finish.countdown',function () {
                seckill.handleSeckill(seckillId,seckillBox);
            });
        } else{
            seckill.handleSeckill(seckillId,seckillBox);
        }
    },

    detail : {
        init : function (params) {
            var killPhone = $.cookie('killPhone');

            if(!seckill.validatePhone(killPhone)){
                var killPhoneModal = $('#killPhoneModal');

                killPhoneModal.modal({
                    show:true,
                    backdrop: 'static',
                    keyboard: false
                });
                $('#killPhoneBtn').click(function () {
                    var inputPhone = $('#killPhoneKey').val();
                    if(seckill.validatePhone(inputPhone)){
                        $.cookie('killPhone',inputPhone,{expires:7,path:'/seckill'});
                        window.location.reload();
                    } else{
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误！</label>').show(300);
                    }
                });
            }

            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];

            $.get(seckill.URL.now(),{},function (result) {
                if(result && result['success']){
                    var nowTime = result['data'];
                    seckill.countdown(seckillId,nowTime,startTime,endTime);
                }else{
                    console.log('result:'+result);
                }
            });

        }
    }
}