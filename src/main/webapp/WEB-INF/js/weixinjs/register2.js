function checkJsonIsEmpty(json) {
	var isEmpty = true;
	if (json == null)
		return true;
	for ( var jsonKey in json) {
		isEmpty = false;
		break;
	}
	return isEmpty;
}
mui.createProcessingMask = function(callback) {
	var element = document.createElement('div');
	element.classList.add('upload-file');
	element.addEventListener('touchmove', mui.preventDefault);
	element.addEventListener('tap', function() {
		//mask.close();
	});
	var processingNode = document.createElement('div');
	processingNode.setAttribute('class', 'mui-loading');
	processingNode.innerHTML = "<div class='mui-spinner' style='width:60px;height:60px;'></div><div style='text-align: center;color:white;'>正在处理请求</div>";
	element.appendChild(processingNode);
	var mask = [ element ];
	mask._show = false;
	mask.show = function() {
		mask._show = true;
		element.setAttribute('style', 'opacity:1');
		//processingNode.style.marginLeft = window.screen.availWidth/2 + "px";
		processingNode.style.marginTop = window.screen.availHeight / 2 - 30
				+ "px";
		document.body.appendChild(element);
		return mask;
	};
	mask._remove = function() {
		if (mask._show) {
			mask._show = false;
			element.setAttribute('style', 'opacity:0');
			mui.later(function() {
				var body = document.body;
				element.parentNode === body && body.removeChild(element);
			}, 350);
		}
		return mask;
	};
	mask.close = function() {
		if (callback) {
			if (callback() !== false) {
				mask._remove();
			}
		} else {
			mask._remove();
		}
	};
	return mask;
};
mui.createTipDialog = function(info, callBack) {
	var template = "<div style='width:80%;margin:50% 10%;border:1px solid #ddd;background-color: white;border-radius: 5px;'><div style='margin-top:20px;margin-left:20px;'>提示信息</div><hr/><div style='margin-top:20px;margin-left:20px;margin-bottom:20px;margin-right:20px;height:60px;'>{{info}}</div></div>";
	var element = document.createElement('div');
	element.classList.add('dialog');
	element.innerHTML = template.replace('{{info}}', info);
	element.addEventListener('touchmove', mui.preventDefault);
	element.addEventListener('tap', function() {
		mask.close();
	});
	var mask = [ element ];
	mask._show = false;
	mask.show = function() {
		mask._show = true;
		element.setAttribute('style', 'opacity:1');
		document.body.appendChild(element);
		return mask;
	};
	mask._remove = function() {
		if (mask._show) {
			mask._show = false;
			element.setAttribute('style', 'opacity:0');
			mui.later(function() {
				var body = document.body;
				element.parentNode === body && body.removeChild(element);
			}, 350);
		}
		return mask;
	};
	mask.close = function() {
		if (callBack) {
			callBack();
		}
		mask._remove();
	};
	return mask;
};
mui.init({
	swipeBack : true
//启用右滑关闭功能
});
mui('.mui-scroll-wrapper').scroll();
function validatemobile(mobile) {
	if (mobile.length == 0) {
		return false;
	}
	if (mobile.length != 11) {
		return false;
	}

	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	if (!myreg.test(mobile)) {
		return false;
	}
	return true;
}

function register() {
	var user_name = document.getElementById('user_name').value;
	var school = document.getElementById('school').value;
	var major = document.getElementById('major').value;
	var grade = document.getElementById('grade').value;
	var country = document.getElementById('country').value;
	if (user_name == null || user_name == "") {
		mui.createTipDialog('请输入您的姓名!', null).show();
		return;
	}
	if (school == null || school == "") {
		mui.createTipDialog('请输入您的学校!', null).show();
		return;
	}
	if (grade == null || grade == "") {
		mui.createTipDialog('请输入您的年级!', null).show();
		return;
	}
	if (major == null || major == "") {
		mui.createTipDialog('请输入您的专业!', null).show();
		return;
	}
	if (country == null || country == "") {
		mui.createTipDialog('请输入您的意向国家!', null).show();
		return;
	}
	var mask = mui.createProcessingMask(null);
	mask.show();
	mui.ajax({
		url : '/weixin/weixinRegisterUserDetailInfo',
		type : "POST",
		data : {
			user_name : user_name,
			school:school,
			major:major,
			grade:grade,
			country:country
		},
		success : function(data) {
			mask.close();
			if (data.error_code == "0") {
				window.location = "/getLiveClass";
			} else {
				mui.createTipDialog(data.error_msg, null).show();
			}
		},
		error : function(status, error) {
			mask.close();
			mui.createTipDialog("服务器暂时无法响应您的请求，请稍后重试！", null).show();
		}
	});
}