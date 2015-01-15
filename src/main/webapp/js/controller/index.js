/**
 * 主页中学习进度内容
 */
function StudyListCtrl($scope) {
	$scope.studyList = [ {
		"cover":"images/index/qrc.png",
		"title" : "二维码学习",
		"desc" : "增加平面二维码的解析与编码."
	}, {
		"cover":"http://www.bootcss.com/p/layoutit/img/people.jpg",
		"title" : "Excel操作学习",
		"desc" : "增加POI文档导出工具."
	}, {
		"cover":"http://www.bootcss.com/p/layoutit/img/city.jpg",
		"title" : "定时任务学习",
		"desc" : "定时任务代码的实现."
	}, {
		"cover":"images/index/map.png",
		"title" : "地图API的学习",
		"desc" : "有Google、GMap,BMap等地图相关的学习."
	} ];
}

