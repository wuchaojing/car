var user = JSON.parse(sessionStorage.getItem('user'))
if (!user) {
    location.href = 'index.html'
}
if (user.name != 'audit') {
    alert('非管理员,请使用管理员登录！')
    location.href = 'index.html'
}
var problem = {
    template: '#problem',
    data() {
        return {
            msg: '',
            stateJudgement: '',
            problemClassification: '',
            subdivisionType: '',
            rank: '',
            auditHierarchy: '',
            repeatQuestion: '',
            completionStatus: '',
            startTime: '',
            endTime: '',
            responsibleArea: '',
            auditHierarchy: '',

            //下边的是ajax获取的信息
            stateJudgements: [],
            auditHierarchys: [],
            ranks: [],
            problemClassifications:[],
            ids:[],
            responsibleAreas:[],
            completionStatuses: [],
              /*  leiwenti: {
                '': '',
                '不安全行为': [
                    '',
                    '驾驶车辆超速',
                    '驾驶车辆不系安全带',
                    '违章停车',
                    '不按要求使用手机',
                    '不走人行道',
                    '不执行3210',
                    '作业不执行SOP',
                    '不佩戴PPE',
                    '双手插兜行走',
                    '其他'
                ],
                '化学品安全': [
                    '',
                    '未按规定张贴标签',
                    '使用其他容器盛装化学品',
                    '区域未张贴SUI和MSDS',
                    '化学品未按规定位置储存',
                    '使用现场未设置洗眼器和点检',
                    '带入未经许可的化学品',
                    '其他',

                ],
                '交通安全': [
                    '',
                    '物流车辆有损坏',
                    '物流车辆点检不全',
                    '其他'
                ],
                '环境保护': [
                    '',
                    '未按规定进行垃圾分类',
                    '排污设备没有正常运行',
                    '危废包装破损',
                    '危险废物包装容器未张贴对应标识',
                    '其他'
                ],
                '消防安全': [
                    '',
                    '灭火器未点检，周围放杂物',
                    '应急照明损坏',
                    '安全通道堵塞',
                    '安全疏散指示标识缺失',
                    '安全出口堵塞',
                    '消防设施破损',
                    '其他'
                ],
                '用电安全': [
                    '',
                    '作业人员未持电工证',
                    '电气设备超负荷或带病运行',
                    '电气设备接线损坏或松脱',
                    '电气设备附近易燃易爆腐蚀品',
                    '配电箱标签缺失或损坏',
                    '用电设施积尘、破损、护罩缺失、线头裸露、运行振动等现象',
                    '配电箱积尘，0.8米有杂物',
                    '其他'
                ],
                '能量锁定': [
                    '',
                    '能量锁无信息或信息不全',
                    '能量锁定图、锁定点与现场信息不对应',
                    '未执行能量锁定流程',
                    '其他'
                ],
                '有限空间': [
                    '',
                    '作业未经过审批，作业证内容与现场不符',
                    '无现场监护或监护人无资质',
                    '无防护措施或措施不到位',
                    '高风险作业所用设备设施损坏',
                    '未按照SOP或作业预计划内容进行作业',
                    '有限空间目视标识有误',
                    '人员进出未按规定登记或未授权人进入',
                    '其他'
                ],
                '危险隔离区': [
                    '',
                    '人员进出未按规定登记或未授权人进入',
                    '现场无监护或监护人员无资质',
                    '无防护措施或措施不到位',
                    '未按照SOP或作业预计划内容进行作业',
                    '危险隔离区目视标识有误',
                    '其他'
                ],
                '高处作业': [
                    '',
                    '作业未经过审批，作业证内容与现场不符',
                    '无现场监护或监护人无资质',
                    '无防护措施或措施不到位',
                    '高风险作业所用设备设施损坏',
                    '未按照SOP或作业预计划内容进行作业',
                    '高处作业人员未考取相关证件',
                    '其他'
                ],
                '机械安全': [
                    '',
                    '作业区域防护缺失',
                    '各种行程限位、联锁装置、抗干扰屏蔽及急停装置故障或失效',
                    '执行机构应定位准确、抓取牢固；自动锁紧装置应灵敏、可靠',
                    '其他'
                ],
                '职业健康': [
                    '',
                    '现场公示信息不全',
                    'PPE使用错误',
                    '其他'
                ],
                '目视化信息': [
                    '',
                    '现场标示牌破损',
                    '现场目视化信息不全、错误',
                    '现场目视化信息未及时更新',
                    '其他'
                ],
                '作业现场及5S': [
                    '',
                    '物品未进行定制定位',
                    '地面不用平整，有障碍物和绊脚物，坑、壕、池应设置盖板或护栏',
                    '地面有积水、积油或垃圾杂物，排水管网不通畅',
                    '通道两边有突出物品或锐边物品',
                    '照明不良',
                    '其他'
                ],
                '管理缺失': [
                    '',
                    '未辨识风险',
                    '未执行TPM或不按规定执行',
                    '未经培训',
                    '其他'
                ]
            },*/
            leimsg: []
        }
    },
    created: function () {
        var me = this
        var date = new Date()
        var year = date.getFullYear()
        var month = date.getMonth() + 1
        if (month == 1 ||month == 3 ||month == 5 ||month == 7) {
            this.startTime = year + '-0' + month + '-01'
            this.endTime = year + '-0' + month + '-31'
        }
        else if (month == 10 ||month == 12) {
            this.startTime = year + '-' + month + '-01'
            this.endTime = year + '-' + month + '-31'
        }
        else if (month == 2) {
            this.startTime = year + '-0' + month + '-01'
            this.endTime = year + '-0' + month + '-28'
        } else if (month == 11) {
            this.startTime = year + '-' + month + '-01'
            this.endTime = year + '-' + month + '-30'
        } else {
            this.startTime = year + '-0' + month + '-01'
            this.endTime = year + '-0' + month + '-30'
        }
        axios.get('http://60.205.187.142:9090/safe_problem/search_this_month')
            .then(function (response) {
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    me.msg = data
                    console.log(me.msg)
                }
            })
        axios.get('http://60.205.187.142:9090/admin/state_judgement')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.stateJudgements.push(data[i].name)
                    }
                }
            })
        axios.get('http://60.205.187.142:9090/admin/rank')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.ranks.push(data[i].name)
                    }
                }
            })
        axios.get('http://60.205.187.142:9090/admin/problem_classification')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.problemClassifications.push(data[i].name)
                        me.ids.push(data[i].id)
                    }
                }
            })
        axios.get('http://60.205.187.142:9090/admin/responsible_area')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.responsibleAreas.push(data[i].name)
                    }
                }
            })
        axios.get('http://60.205.187.142:9090/admin/audit_hierarchy')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.auditHierarchys.push(data[i].name)
                    }
                }
            })
        /*axios.get('http://60.205.187.142:9090/admin/rank')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.problemClassifications.push(data[i].name)
                    }
                }
            })*/
    },
    methods: {
        searchGo: function () {
            var id;
            var me = this;
            if(this.problemClassification == ''){
                this.subdivisionType = ''
                this.leimsg = ''
            }else {
                this.subdivisionType = ''
                for(var i=0;i<this.problemClassifications.length;i++) {
                    if(this.problemClassifications[i]==this.problemClassification){
                        id = this.ids[i]
                        break;
                    }
                }
                me.leimsg = []
                axios.get('http://60.205.187.142:9090/admin/subdivision_type?problemClassificationId='+id)
                    .then(function(response){
                       var code = response.data.code
                       var msg = response.data.msg
                       if (code != 1) {
                                if (msg == 'need login') {
                                    location.href = 'index.html'
                                }
                            } else {
                                var data = response.data.data
                                for(var i=0;i<data.length;i++)
                                {
                                    me.leimsg.push(data[i].name)
                                }
                            }
                        })

            }

        },
        go: function () {
            var msg = this.search()
            var dataName = window.prompt('请输入名字')
            if (dataName == null) {
                return;
            }
            if (!dataName) {
                alert('请输入名字')
                return;
            }
            var tHeader = [
                '序号',
                '审计区域',
                '提出时间',
                '问题描述',
                '图片',
                '状态判断',
                '问题分类',
                '细分类型',
                '等级',
                '整改措施',
                '责任区域',
                '责任人',
                '完成期限',
                '审计层级',
                '是否重复照片',
                '完成状态',
                '完成照片',
            ]
            var dataAdd = []
            for (var i = 0; i < msg.length; i++) {
                if (msg[i].photo) {
                    msg[i].pho = 'http://qiniu.snroom.com/@' + msg[i].photo
                } else {
                    msg[i].pho = ''
                }
                if (msg[i].finishPhoto) {
                    msg[i].finish = 'http://qiniu.snroom.com/@' + msg[i].finishPhoto
                } else {
                    msg[i].finish = ''
                }
                var data = {
                    index: i + 1,
                    auditArea: msg[i].auditArea,
                    proposeTime: msg[i].proposeTime,
                    problemDescription: msg[i].problemDescription,
                    photo: msg[i].pho,
                    stateJudgement: msg[i].stateJudgement,
                    problemClassification: msg[i].problemClassification,
                    subdivisionType: msg[i].subdivisionType,
                    rank: msg[i].rank,
                    rectificationMeasures: msg[i].rectificationMeasures,
                    responsibleArea: msg[i].responsibleArea,
                    personLiable: msg[i].personLiable,
                    completionDeadline: msg[i].completionDeadline,
                    auditHierarchy: msg[i].auditHierarchy,
                    repeatQuestion: msg[i].repeatQuestion,
                    completionStatus: msg[i].completionStatus,
                    finishphoto: msg[i].finish
                }
                dataAdd.push(data)
            }
            var tbody = dataAdd
            export2Excel(tHeader, tbody, dataName + '.xlsx')
        },
        search: function () {
            var msg = []
            for (var i = 0; i < this.msg.length; i++) {
                var flag = true
                if(i==0) {
                    console.log(this.subdivisionType)
                    console.log(this.problemClassification)
                }
                if (this.msg[i].stateJudgement.indexOf(this.stateJudgement) != -1 && this.msg[i].problemClassification.indexOf(this.problemClassification) != -1 && this.msg[i].rank.indexOf(this.rank) != -1 && this.msg[i].auditHierarchy.indexOf(this.auditHierarchy) != -1 && this.msg[i].repeatQuestion.indexOf(this.repeatQuestion) != -1 &&this.msg[i].responsibleArea.indexOf(this.responsibleArea)!= -1) {
                    if (this.subdivisionType == '其他') {
                        for (var j = 0; j < this.leimsg.length - 1; j++) {
                            if (this.leimsg[j].indexOf(this.msg[i].subdivisionType) != -1) {
                                flag = false
                            }
                        }
                        if (this.completionStatus == '' && flag) {
                            var arr = this.msg[i].completionStatus.split('/')
                            if ((arr[0] == '完成') || (arr[0] == '已完成')) {
                                this.msg[i].status = 1
                            } else if (arr[0] == '未完成') {
                                this.msg[i].status = 0
                            } else {
                                if (!isNaN(parseInt(arr[0]))) {
                                    var c = parseInt(arr[0])
                                    var d = parseInt(arr[1])
                                    this.msg[i].status = parseInt(c / d)
                                }
                            }
                            msg.push(this.msg[i])
                        } else if (this.completionStatus == '完成' && flag) {
                            if (this.msg[i].status == 1) {
                                msg.push(this.msg[i])
                            }
                        } else {
                            if (this.msg[i].status == 0 && flag) {
                                msg.push(this.msg[i])
                            }
                        }
                    } else {
                        if(this.msg[i].subdivisionType===null) this.msg[i].subdivisionType=''
                        if (this.msg[i].subdivisionType.indexOf(this.subdivisionType) != -1) {
                            if (this.completionStatus == '') {
                                var arr = this.msg[i].completionStatus.split('/')
                                if ((arr[0] == '完成') || (arr[0] == '已完成')) {
                                    this.msg[i].status = 1
                                } else if (arr[0] == '未完成') {
                                    this.msg[i].status = 0
                                } else {
                                    if (!isNaN(parseInt(arr[0]))) {
                                        var c = parseInt(arr[0])
                                        var d = parseInt(arr[1])
                                        this.msg[i].status = parseInt(c / d)
                                    }
                                }
                                msg.push(this.msg[i])
                            } else if (this.completionStatus == '完成') {
                                if (this.msg[i].status == 1) {
                                    msg.push(this.msg[i])
                                }
                            } else {
                                if (this.msg[i].status == 0) {
                                    msg.push(this.msg[i])
                                }
                            }
                        }
                    }

                }
            }

            return msg
        },
        getTime: function () {
            if (this.startTime == '' && this.endTime == '') {
                return this.search()
            }
            var me = this
            var start = this.startTime + '+00:00:00'
            var end = this.endTime + '+23:59:59'
            axios.get('http://60.205.187.142:9090/safe_problem/search?startTime=' + start + '&endTime=' + end)
                .then(function (response) {
                    var code = response.data.code
                    var msg = response.data.msg
                    if (code != 1) {
                        alert(msg)
                        if (msg == 'need login') {
                            location.href = 'index.html'
                        }
                    } else {
                        var data = response.data.data
                        me.msg = data
                    }
                })
        }
    }
}
var zong = {
    template: '#zong',
    data() {
        return {
            flag: true,
            hierarchy: '',
            hierarchyCompleteRatio: '',
            problemType: '',
            companyAudit: '',
        }
    },
    created: function () {
        var me = this
        axios.get('http://60.205.187.142:9090/safe_problem/audit')
            .then(function (response) {
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        alert(msg)
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    me.hierarchy = data.hierarchy
                    me.hierarchyCompleteRatio = data.hierarchyCompleteRatio
                    for (var i = 0; i < me.hierarchyCompleteRatio.length; i++) {
                        me.hierarchyCompleteRatio[i].complete_ratio = me.hierarchyCompleteRatio[i].complete_ratio * 100 + '%'
                    }
                    me.problemType = data.problemType
                    me.companyAudit = data.companyAudit
                }
            })
    }
}
var router = new VueRouter({
    routes: [
        {
            path: '/',
            redirect: '/problem'
        },
        {
            path: '/problem',
            component: problem
        },
        {
            path: '/zong',
            component: zong
        }
    ]
})
var vm = new Vue({
    el: '#app',
    data: {
        flag: false,
        newValue: '',
        newValue2: '',
        oldValue: '',
        userName: user.name,
    },
    methods: {
        repass: function () {
            var me = this
            if (this.newValue != this.newValue2) {
                alert('确认密码和新密码不一致')
                return;
            }
            axios.post('http://60.205.187.142:9090/user/update_password?oldPassword=' + this.oldValue + '&newPassword=' + this.newValue)
                .then(function (response) {
                    var code = response.data.code
                    var msg = response.data.msg
                    if (code != 1) {
                        alert(msg)
                        if (msg == 'need login') {
                            location.href = 'index.html'
                        }
                    } else {
                        alert('修改成功')
                        me.flag = false
                    }
                })
        },
        exit: function () {
            sessionStorage.removeItem('user')
            location.href = 'index.html'
        }
    },
    router: router
})

