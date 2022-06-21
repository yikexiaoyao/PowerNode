<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/11/29
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
    let isCommitted = false;//表单是否已经提交标识，默认为false
    function dosubmit(){
        if(isCommitted==false){
            isCommitted = true;//提交表单后，将表单是否已经提交标识设置为true
            return true;//返回true让表单正常提交
        }else{
            return false;//返回false那么表单将不提交
        }
    }
</script>
<body>
    <h1>欢迎您【${user.username}】来到Redis投票系统</h1>
    <hr />

    <%--发布文章模态窗口--%>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">发布文章</h4>
                </div>
                <div class="modal-body">
                    <form id="form" action="${pageContext.request.contextPath}/article/push" onsubmit="return dosubmit()" method="post">
                        <div class="form-group">
                            <label>文章标题</label>
                            <input type="text" name="title" class="form-control"  placeholder="请输入标题">
                        </div>
                        <div class="form-group">
                            <label>文章链接</label>
                            <input type="text" name="link" class="form-control" placeholder="请输入链接">
                        </div>
                        <div class="form-group">
                            <label>文章内容</label>
                            <textarea class="form-control" name="content" rows="3" placeholder="请输入文章内容"></textarea>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <%--<button type="button" id="pubBtn" class="btn btn-primary">发布文章</button>--%>
                            <input type="submit"  class="btn btn-primary" value="发布文章">
                        </div>
                    </form>
                </div>


            </div>
        </div>
    </div>

    <table style="text-align: center;width: 1200px;margin: 20px auto" class="table table-bordered table-striped">
        <caption><h3 style="text-align: center">Redis投票系统</h3></caption>
        <tr>
            <td colspan="4">
                <a href="javascript:void(0)" class="btn btn-success" data-toggle="modal" data-target="#myModal">发布文章</a>
                <a href="${pageContext.request.contextPath}/article/list?type=votes&ascOrDesc=asc" class="btn btn-success">投票升序</a>
                <a href="${pageContext.request.contextPath}/article/list?type=votes&ascOrDesc=desc" class="btn btn-success">投票降序</a>
                <a href="${pageContext.request.contextPath}/article/list?type=time&ascOrDesc=asc" class="btn btn-success">发布时间升序</a>
                <a href="${pageContext.request.contextPath}/article/list?type=time&ascOrDesc=desc" class="btn btn-success">发布时间降序</a>
            </td>
            <td colspan="3">
                <form class="form-inline" action="${pageContext.request.contextPath}/article/list">
                    <div class="form-group">
                        <input type="text" class="form-control" id="exampleInputEmail3" name="keyword" placeholder="请输入文章标题">
                        <input type="hidden" value="${type}">
                        <input type="hidden" value="${ascOrDesc}">
                        <input type="hidden" value="search" name="option">
                    </div>
                    <input type="submit" class="btn btn-primary" value="查询"/>
                </form>
            </td>
        </tr>
        <tr>
            <th>文章编号</th>
            <th>文章标题</th>
            <th>文章链接</th>
            <th>发布者</th>
            <th>发布时间</th>
            <th>投票数</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.aid}</td>
                <td>${article.title}</td>
                <td>${article.link}</td>
                <td>${article.uid}</td>
                <td>${article.pubTime}</td>
                <td>${article.votes}</td>
                <td>
                    <button class="btn btn-info">修改</button>
                    <button class="btn btn-danger">删除</button>
                    <button class="btn btn-success" onclick="vote(${article.aid})">投票</button>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="7">
                <nav aria-label="Page navigation">
                    <ul class="pagination pagination-lg">
                        <li>
                            <c:if test="${pageNow - 1 > 0}">
                                <a href="${pageContext.request.contextPath}/article/list?page=${pageNow - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </c:if>

                        </li>

                        <c:forEach begin="1" end="${pages}" var="page">
                            <c:choose>
                                <c:when test="${pageNow == page}">
                                    <li class="active"><a href="${pageContext.request.contextPath}/article/list?page=${page}">${page}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${pageContext.request.contextPath}/article/list?page=${page}">${page}</a></li>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>

                        <li>
                            <c:if test="${pageNow + 1 <= pages}">
                                <a href="${pageContext.request.contextPath}/article/list?page=${pageNow + 1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </c:if>
                        </li>
                    </ul>
                </nav>
            </td>
        </tr>
    </table>

    <script>
        //发布文章
        /*$('#pubBtn').click(function () {
            $('#form').submit();
        });*/

        //投票
        function vote(id) {
            $.get("${pageContext.request.contextPath}/article/vote",{
                'id' : id
            },function (data) {
                //data:ResultVo
                if(!data.ok){
                    alert(data.message);
                }else{
                    //再次查询最新票数
                    location.href = "${pageContext.request.contextPath}/article/list";
                }
            },'json');
        }

        //查询
    </script>
</body>
</html>
