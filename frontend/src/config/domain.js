/* Copyright 2026 上海如静知华信息科技有限公司 */
export const domain={
 code:'RECRUITAI',systemName:'知华 AI 招聘协同平台',englishName:'AI TALENT ACQUISITION',theme:{primary:'#4f638e',dark:'#232d47',accent:'#b97958',},
 workspace:'人力资源中心 / 人才获取部',fieldWorkspace:'技术招聘组',period:'2026-08-04 · 实时运营',liveText:'运营数据于 10:36 更新',fieldContextLabel:'当前工作周期',fieldContext:'八月第一周',fieldUser:'顾晨',fieldRole:'招聘顾问',adminUser:'林岚',adminRole:'招聘运营负责人',
 adminTitle:'人才获取智能运营台',adminBreadcrumb:'招聘智能运营 / 全局态势',adminSubtitle:'从职位供需、候选人漏斗、匹配质量和面试进度观察招聘效率。',exportAction:'导出运营报告',createAction:'新建招聘任务',
 chartTitle:'招聘处理完成趋势',chartSubtitle:'本月实际完成率 / 运营目标',chartLabels:['01日','05日','09日','13日','17日','21日','25日','29日','31日'],loadTitle:'招聘领域负荷',loadSubtitle:'开放任务占团队处理能力',recordsTitle:'重点招聘任务',recordsSubtitle:'按优先级、期限与待校准排序',issueTitle:'需要关注的运营事项',issueSubtitle:'需要跨团队确认或升级处理',
 recordName:'招聘任务',itemName:'职位',unitName:'招聘团队',batchName:'人才类别',planName:'候选人',doneName:'已推进',exceptionName:'待校准',unitLabel:'项',
 listBreadcrumb:'招聘工作台 / 招聘任务',listSubtitle:'覆盖职位需求、简历结构化、人才匹配、面试协同和录用分析的企业招聘智能工作台。',listSummary:[['在招职位','68'],['本周处理','24'],['待校准','9'],['高优先级','3',true]],tabs:['全部','待处理','进行中','待确认','已归档'],
 fieldBreadcrumb:'招聘运营 / 招聘顾问工作台',fieldTitle:'招聘顾问工作台',fieldSubtitle:'在招职位 12 个 · 待沟通 28 人 · 今日面试 6 场',fieldSecondary:'查看工作日历',reportAction:'提交处理反馈',fieldNoticeTitle:'智能服务运行正常',fieldNotice:'任务数据完整率 93.8%',
 steps:[
 '需求确认',
 '简历解析',
 '人才匹配',
 '面试协同',
 '录用复盘'
],documentAction:'查看操作手册',printAction:'导出工作档案',resourceCardTitle:'智能资源状态',resourceValueLabel:'当前处理量',resourceHealthLabel:'服务健康度',quickSubtitle:'常用工作入口',quickActions:[
 [
  '简历解析',
  '/shopfloor/report',
  '技能、经历与项目结构化'
 ],
 [
  '职位中心',
  '/shopfloor/material',
  'JD、画像与招聘优先级'
 ],
 [
  '人才池',
  '/shopfloor/resources',
  '匹配、沟通与活跃度'
 ],
 [
  '公平性复核',
  '/shopfloor/andon',
  '偏差、拒绝原因与人工复核'
 ]
],
 reportDefaults:[6,1],reportTitle:'招聘任务处理反馈',reportSubtitle:'记录已推进、待校准和处理建议。',reportSuccess:'候选人推进记录已提交',reportPlaceholder:'填写处理结论、引用依据、后续要求与负责人',reportFootnote:'提交后自动进入负责人复核队列',ruleTitle:'智能处理质量门禁',ruleSubtitle:'RECRUITAI-POLICY · V1.0',rules:[['人工复核','关键结果必须'],['引用与依据','必须保留'],['权限检查','执行前完成'],['运行评估','每月',true]],fieldTotals:[['68','在招职位'],['3','高优先级'],['9','待校准'],['93.8%','数据完整率']],
 adminMenus:[['/admin','home','运营控制中心'],['/admin/work-orders','order','招聘任务'],['/admin/samples','box','职位台账'],['/admin/schedule','calendar','计划与排期'],['/admin/methods','process','规则与模板'],['/admin/reviews','quality','审核与决策'],['/admin/resources','machine','智能资源'],['/admin/report','chart','运营分析']],
 fieldMenus:[['/shopfloor','home','招聘顾问工作台'],['/shopfloor/report','report','处理反馈'],['/shopfloor/tasks','order','我的任务'],['/shopfloor/material','box','职位台账'],['/shopfloor/resources','machine','智能资源'],['/shopfloor/andon','risk','问题升级',3]],
 moduleTitles:{tasks:['我的待办任务','查看优先级、期限与处理状态'],material:['职位台账','查询完整资料、历史版本与责任人'],resources:['智能资源中心','管理知识、模型、连接器和处理服务'],andon:['问题升级','提交重大风险、争议或阻塞事项'],samples:['职位台账','统一管理业务对象、资料与上下游依赖'],schedule:['计划与排期','协调负责人、参与方和交付窗口'],methods:['规则与模板','维护处理口径、质量标准和模板'],reviews:['审核与决策','记录确认、驳回和复核要求'],report:['运营分析','分析质量、效率、异常和处理周期']},
 tagline:'让招聘判断有依据、候选人体验有温度',storyTitle:'让招聘判断有依据、候选人体验有温度',storyText:'覆盖职位需求、简历结构化、人才匹配、面试协同和录用分析的企业招聘智能工作台。',pattern:[2,4,7,9,12,15,18,21,24,27,29,31],loginStats:[['60','在招职位'],['93.8%','数据完整率'],['3','高优先级']],loginTitle:'人才获取智能运营台',adminDemo:'管理 / 运营 / 分析',fieldDemo:'任务 / 处理 / 反馈'
}
export const records=[
 {no:'REC-260804-018',name:'高级 Java 工程师招聘',code:'JAVA-SENIOR',unit:'技术招聘组',group:'研发中心',plan:24,done:16,exception:3,due:'08-08',batch:'社会招聘',status:'面试中',progress:67,priority:'加急'},
 {no:'REC-260804-021',name:'AI 产品经理人才寻访',code:'AI-PM',unit:'产品招聘组',group:'产品中心',plan:18,done:8,exception:2,due:'08-09',batch:'关键岗位',status:'待校准',progress:44,priority:'关注'},
 {no:'REC-260804-026',name:'客户成功经理招聘',code:'CSM-SH',unit:'业务招聘组',group:'商业中心',plan:12,done:0,exception:0,due:'08-10',batch:'社会招聘',status:'筛选中',progress:12,priority:'加急'},
 {no:'REC-260803-015',name:'数据分析实习生项目',code:'DATA-INTERN',unit:'校园招聘组',group:'人力资源中心',plan:20,done:20,exception:1,due:'08-06',batch:'校园招聘',status:'已关闭',progress:100,priority:'正常'},
 {no:'REC-260804-031',name:'解决方案架构师寻访',code:'SA-ENTERPRISE',unit:'技术招聘组',group:'研发中心',plan:16,done:11,exception:2,due:'08-11',batch:'关键岗位',status:'背调中',progress:76,priority:'关注'}
]
export const resources=[{code:'PARSE-CV-01',name:'简历结构化解析',unit:'人才数据组',status:'运行中',health:97,value:'326',valueUnit:'份',note:'字段完整率 96.8%'},{code:'MATCH-JD-02',name:'职位人才匹配引擎',unit:'招聘运营组',status:'复核中',health:86,value:'42',valueUnit:'人',note:'4 个推荐等待顾问确认'},{code:'INT-COPILOT-03',name:'面试协同助手',unit:'面试官中心',status:'预警',health:78,value:'18',valueUnit:'场',note:'2 场反馈尚未提交'}]
export const reviews=[{no:'CAL-260804-032',title:'AI 产品经理人才校准',type:'人才校准',detail:'8 位候选人 · 林岚',result:'待确认'},{no:'INT-260804-011',title:'Java 工程师技术面反馈',type:'面试复核',detail:'6 份反馈 · 顾晨',result:'通过'},{no:'BIAS-260803-018',title:'校园招聘筛选公平性检查',type:'算法审计',detail:'差异 2 项',result:'异常'}]
export const adminMetrics=[['在招职位','68','较上月新增 6','blue'],['本周处理','24','平均周期 2.6 天','green'],['待校准','9','其中 3 项临近期','orange'],['高优先级','3','需要负责人决策','red']]
export const fieldMetrics=[['我的任务','6','3 项高优先级','blue'],['今日已处理','18','质量检查已完成','green'],['待校准','9','3 项临近期限','orange'],['数据完整率','93.8%','较上周提升 2.4%','slate']]
export const chartActual=[18,26,37,45,56,63,72,81,87],chartTarget=[20,30,40,50,60,70,80,90,96]
export const loads=[
 [
  '技术与研发岗位',
  88,
  '开放职位 9 个'
 ],
 [
  '产品与设计岗位',
  76,
  '开放职位 5 个'
 ],
 [
  '销售与客户成功',
  69,
  '开放职位 7 个'
 ],
 [
  '职能与校园招聘',
  58,
  '开放职位 4 个'
 ]
]
export const issues=[
 [
  '校准',
  'AI 产品经理核心能力权重存在分歧',
  '影响推荐排序 · 校准会 08-05',
  '待审议'
 ],
 [
  '反馈',
  '两场技术面试超过 24 小时未反馈',
  '涉及候选人体验',
  '提醒中'
 ],
 [
  '合规',
  '一批历史简历即将超过保留期限',
  '需完成删除或续期授权',
  '待处理'
 ]
].map(x=>({type:x[0],title:x[1],detail:x[2],status:x[3]}))
