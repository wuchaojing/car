var user = JSON.parse(sessionStorage.getItem('user'))
if(!user) {
    location.href = 'index.html'
}
var vm = new Vue({
  el: '#app',
  data: {
      flag: false,
      newValue: '',
      newValue2: '',
      oldValue: '',
      userName: user.name,
      msg: ''
    },
    methods:{
        repass: function() {
            var me = this
            if(this.newValue!=this.newValue2) {
                alert('确认密码和新密码不一致')
                return;
            }
            axios.post('http://localhost:8080/user/update_password?oldPassword='+this.oldValue+'&newPassword='+this.newValue)
                .then( function(response) {
                    var code = response.data.code
                    var msg = response.data.msg
                    if(code!=1) {
                        alert(msg)
                        if(msg=='need login') {
                            location.href = 'index.html'
                        }
                    }else {
                        alert('修改成功')
                        me.flag = false
                    }
                })
        },
        exit:function() {
            sessionStorage.removeItem('user')
            location.href = 'index.html'
        }
    },
    created:function() {
      var me = this
      var recordId = JSON.parse(sessionStorage.getItem('recordId'))
        axios.get('http://localhost:8080/record/safe_problems?recordId='+recordId)
            .then(function (response){
                var code = response.data.code
                var msg = response.data.msg
                var data = response.data.data
                if(code!=1) {
                    alert(msg)
                    if(msg=='need login') {
                        location.href = 'index.html'
                    }
                }else {
                    // sessionStorage.removeItem('recordId')
                    me.msg = data
                    console.log(data)
                }
            })
    }
})