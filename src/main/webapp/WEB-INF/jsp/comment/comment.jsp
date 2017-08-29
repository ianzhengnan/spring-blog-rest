<%--
  Created by IntelliJ IDEA.
  User: I076453
  Date: 8/29/2017
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" language="java" %>

<p>评论（${article.commentCount}）</p>
<textarea id="commend_content" rows="8" cols="50" name="content"></textarea><br>
<button>提交</button>
<br>

<div id="comments">
<c:forEach items="${comments}" var="comment">
    <div>
        <p><span style="font-weight: 700">${comment.createBy.username}</span></p>
        <p><span style="font-size: xx-small">${comment.createAt}</span></p>
        <p>内容：${comment.content}</p>
    </div>
</c:forEach>
</div>

<script>

    $(document).ready(function(){
        $("button").click(function(){
            var commentContent = $("#commend_content").val();
            $.post(
                "${ctx}/${sessionScope.user_session.username}/article/${article.id}/comments",
                {content: commentContent},
                function(result, textStatus, jqxhr){
                    if(textStatus === 'success'){
                        $("#art_comment").html(result);
                    }else if(textStatus === "error"){
                        alert(result);
                    }
                });
        });
    });

</script>