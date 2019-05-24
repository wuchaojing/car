var user = JSON.parse(sessionStorage.getItem('user'))
if(!user) {
    alert('请先登录！')
    location.href = 'index.html'
}
var vm = new Vue({
  el: '#app',
  data: {
      compName: 'upload',
    flag: false,
      newValue: '',
      newValue2: '',
      oldValue: '',
      userName: user.name,
      submits: '',
      file: ''
  },
  methods: {
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
    components:{
      upload: {
          template: '#upload',
          methods: {
              upload: function(event) {
                  this.file = event.target.files[0]
              },
              submit:function(event){
                  var formdata = new FormData();
                  formdata.append('myFiles',this.file);
                  var config = {
                      headers: {
                          'Content-Type': 'multipart/form-data'  //之前说的以表单传数据的格式来传递fromdata
                      }
                  };
                  axios.post('http://localhost:8080/safe_problem/upload', formdata, config)
                      .then(function(response){
                          var code = response.data.code
                          var msg = response.data.msg
                          if(code!=1) {
                              alert(msg)
                              if(msg=='need login') {
                                  location.href = 'index.html'
                              }
                          }else {
                              alert('上传成功!')
                              location.href = 'userIndex.html'
                          }
                      })
              }



          }
      },
      submitRecodes : {
          template: '#submitRecodes',
          data: function() {
              return {

              }
          },
          methods: {
              go: function(id) {
                  axios.get('http://localhost:8080/record/safe_problems?recordId='+id)
                      .then(function (response){
                          var code = response.data.code
                          var msg = response.data.msg
                          if(code!=1) {
                              alert(msg)
                              if(msg=='need login') {
                                  location.href = 'index.html'
                              }
                          }else {
                              sessionStorage.setItem('recordId',JSON.stringify(id))
                              location.href = 'detail.html'
                          }
                      })
              }
          },
          props: ['submits']
      }

  },
    created: function() {
      var me = this
        axios.get('http://localhost:8080/record/relative_records')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if(code!=1){
                    alert(msg)
                    if(msg=='need login') {
                        location.href = 'index.html'
                    }
                }else {
                    var data = response.data.data
                    me.submits = data
                }
            })
    }
})
