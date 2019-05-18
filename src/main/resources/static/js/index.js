//组件
Vue.prototype.$axios = axios;
var vm = new Vue({
  el: '#app',
  data: {
    compName:'login',
    flag: true
  },
  methods:{
  },
  components: {
      login: {
          template: '#login',
          data: function () {
              return {
                  username: '',
                  password: '',
              }
          },
          methods: {
              //添加active类效果
              getMsg: function () {
                  this.$axios.get('http://localhost:8080/user/login?number=' + this.username + '&password=' + this.password)
                      .then(function (response) {
                          var code = response.data.code
                          var msg = response.data.msg
                          if (code != 1) {
                              alert(msg)
                          } else {
                              alert('登录成功'+code)
                              location.href = 'index.html'
                          }
                      })
              }
          }

      },
      register: {
          template: '#register',
          data: function () {
              return {
                  flag: false,
                  higherName: '',
                  name:'',
                  password: '',
                  password2:'',
                  number: '',
                  position: []

              }
          },
          created: function () {
              var me = this;
              this.$axios.get('http://localhost:8080/user/register_superior')
                  .then(function (response) {
                      // console.log(1)
                      var code = response.data.code
                      console.log(code)
                      var msg = response.data.data
                      console.log(msg)
                      if (code != 1) {
                          alert(msg)
                      } else {
                          me.position = msg
                      }
                  })
          },
          methods: {
              show: function () {
                  this.flag = true
              },
              hide: function () {
                  this.flag = false
              },
              showIn: function (name) {
                  this.flag = false
                  this.higherName = name
              },
              search: function (name) {
                  var position = []
                  for (var i = 0; i < this.position.length; i++) {
                      if (this.position[i].name.indexOf(name) !== -1) {
                          position.push(this.position[i])
                      }
                  }
                  return position
              },
              sendMsg:function() {
                  if(this.password!=this.password2){
                      alert('两次密码不一致')
                      return ;
                  }else {
                      var id
                      for(var i=0;i<this.position.length;i++) {
                          if(this.position[i].name == this.higherName){
                              id = this.position[i].userId
                              break;
                          }
                      }
                      console.log(id)

                      var data = {name:this.name,password:this.password,number:this.number,superiorId:id}
                      console.log(data)
                      this.$axios({
                          method:'post',
                          url:'http://localhost:8080/user/register',
                          data:JSON.stringify(data)
                      }).then(function(response){
                          var code = response.data.code
                          var msg = response.data.msg
                          if(code!=1){
                              alert(msg)
                          }else {
                              alert('注册成功')
                          }
                      })
                  }


              }
          }
      }
  }
});
