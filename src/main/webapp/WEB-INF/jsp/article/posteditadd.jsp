<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增文章</title>
<script type="text/javascript" src="${ctx }/js/jquery.1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx }/js/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="${ctx }/js/xheditor_lang/zh-cn.js"></script>
<style type="text/css">
	.btnCode {
		background: transparent url(img/code.png) no-repeat 0px 0px;
		background-position: 3px -2px;
	}
</style>
<script>
	$(pageInit);
	
	function submitForm(){
		return true;
	}
	
	function onSaveBtnPressed(e){
		document.getElementById("ispub").value = '2';
	}
	
	function onPostBtnPressed(e){
		document.getElementById("ispub").value = '1';
	}
	
	function pageInit(){
		$('#content').xheditor({upLinkUrl:'/upload',upLinkExt:"zip,rar,txt",upImgUrl:'/upload',upImgExt:'jpg, jpeg,png,gif'});
	}
	
</script>
<script type="text/javascript">  
      $(function(){  
       var plugins={  
        Code:{c:'btnCode',t:'插入代码',h:1,e:function(){  
            var _this=this;  
            var htmlCode="<div>编程语言<select id='xheCodeType'>";  
                htmlCode+="<option value='html'>HTML/XML</option>";  
                htmlCode+="<option value='js'>Javascript</option>";  
                htmlCode+="<option value='css'>CSS</option>";  
                 htmlCode+="<option value='php'>PHP</option>";  
                 htmlCode+="<option value='java'>Java</option>";  
                 htmlCode+="<option value='py'>Python</option>";  
                 htmlCode+="<option value='pl'>Perl</option>";  
                 htmlCode+="<option value='rb'>Ruby</option>";  
                 htmlCode+="<option value='cs'>C#</option>";  
                 htmlCode+="<option value='c'>C++/C</option>";  
                 htmlCode+="<option value='vb'>VB/ASP</option>";  
                 htmlCode+="<option value=''>其它</option>";  
                 htmlCode+="</select></div><div>";  
                 htmlCode+="<textarea id='xheCodeValue' wrap='soft' spellcheck='false' style='width:300px;height:100px;' />";  
                 htmlCode+="</div><div style='text-align:right;'><input type='button' id='xheSave' value='确定' /></div>";           
             var jCode=$(htmlCode),jType=$('#xheCodeType',jCode),jValue=$('#xheCodeValue',jCode),jSave=$('#xheSave',jCode);  
             jSave.click(function(){  
                 _this.loadBookmark();  
                 _this.pasteHTML('<pre class="brush: '+jType.val()+'">'+_this.domEncode(jValue.val())+'</pre> ');  
                 _this.hidePanel();  
                 return false;     
             });  
             _this.saveBookmark();  
             _this.showDialog(jCode);  
         }},  
               
         };  
         $('#content').xheditor({  
             plugins:plugins,//使用我们定义的插件    
             loadCSS:'<style>pre{margin-left:2em;border-left:3px solid #CCC;padding:0 1em;}</style>',  
         });  
     })
</script>
</head>
<body>
	<%-- <form action="postedit" method="post" onsubmit="return submitForm()">
		类别：<select name="category_id">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">${category.title}</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		主题：<input id="ispub" type="hidden" name="isPub" value="2">
		<input type="hidden" name="id" value="${article.id}">
		<input type="text" name="subject" value="${article.subject}" width="50%"><form:errors path="subject" cssStyle="color: red"/><br>
		内容：<br>
		<textarea id="content" name="content" rows="20" cols="150">${article.content}</textarea><form:errors path="content" cssStyle="color: red"/><br>
		<input type="submit" value="Save" id="saveBtn" onclick="onSaveBtnPressed()">&nbsp;&nbsp;
		<input type="submit" value="Post" id="postBtn" onclick="onPostBtnPressed()">
	</form> --%>
	
	<p><a href="${ctx}/main">主页</a></p>
	<form:form modelAttribute="article" method="post" action="postedit">
		<form:select path="category" items="${categories}" itemLabel="title" itemValue="id"/>&nbsp;&nbsp;
		主题：<input id="ispub" type="hidden" name="isPub" value="2">
		<form:hidden path="id" />
		<form:input path="subject" /><form:errors path="subject" cssStyle="color:red"/><br>
		内容:<br>
		<form:textarea path="content" rows="20" cols="150" /><form:errors path="content" cssStyle="color: red"/><br>
		
		<input type="submit" value="Save" id="saveBtn" onclick="onSaveBtnPressed()">&nbsp;&nbsp;
		<input type="submit" value="Post" id="postBtn" onclick="onPostBtnPressed()">
	</form:form>
	
</body>
</html>