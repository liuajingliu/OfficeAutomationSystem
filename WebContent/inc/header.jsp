<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<!-- 导航条开始 -->
	<nav class="navbar navbar-default  navbar-fixed-top">
		<!-- 内部容器开始 -->
		<div class="container">
			<!-- 导航头部开始 -->
			<div class="navbar-header">
				<!-- 响应式菜单按钮开始 -->
				<button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navMenu">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- 响应式菜单按钮结束 -->
				<!-- logo开始 -->
				<a href="#" class="navbar-brand">ICSS</a>
				<!-- logo结束 -->
			</div>
			<!-- 导航头部结束 -->
			<!-- 导航菜单开始 -->
			<div id="navMenu" class="collapse navbar-collapse">
				<!-- 菜单列表开始 -->
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">菜单1</a></li>
					<li><a href="#">菜单2</a></li>
					<li><a href="#">新闻</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							菜单3
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">子菜单1</a></li>
							<li><a href="#">子菜单2</a></li>
						</ul>
					</li>
				</ul>
				<!-- 菜单列表结束 -->
				<!-- 普通文本开始  -->
				<p class="navbar-text">
					当前用户：
					<a href="#" class="navbar-link">
						${adminName}
					</a>
				</p>
				<!-- 普通文本结束 -->
				<!-- 表单开始 -->
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="search" class="form-control" placeholder="请输入搜索关键字">
						<input type="submit" class="btn btn-success" value="搜索">
					</div>
				</form>
				<!-- 表单结束 -->
				<!-- 退出登录开始 -->
				<a href="#" class="btn btn-danger navbar-btn navbar-right">退出登录</a>
				<!-- 退出登录结束 -->
			</div>
			<!-- 导航菜单结束 --> 
		</div>
		<!-- 内部容器结束 -->
	</nav>
	<!-- 导航条结束 -->

	<!-- 轮播图开始 -->
	<div class="container-fluid" style="padding:0">    
   		<!--轮播容器-->
        <div id="myCarousel" class="carousel slide">        
        	<!--轮播指针-->
        	<ol class="carousel-indicators">
              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#myCarousel" data-slide-to="1"></li>
              <li data-target="#myCarousel" data-slide-to="2"></li>             
            </ol>
        	<!--轮播项目-->
            <div class="carousel-inner">
            	<div class="item active">
                	<img src="images/img_main_1.jpg">
                </div>
                <div class="item">
                	<img src="images/img_main_2.jpg">
                </div>
                <div class="item">
                	<img src="images/img_main_3.jpg">
                </div>
            </div>
            <!--轮播导航-->         
            <a href="#myCarousel" class="carousel-control left" data-slide="prev">&lsaquo;</a>
            <a href="#myCarousel" class="carousel-control right" data-slide="next">&rsaquo;</a>
        </div>    
    </div>
    <!-- 轮播图结束 -->

    <!-- 导航条开始 -->
	<nav class="navbar navbar-default">
		<!-- 内部容器开始 -->
		<div class="container">
			<!-- 导航头部开始 -->
			<div class="navbar-header">
				<!-- 响应式菜单按钮开始 -->
				<button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navMenu2">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- 响应式菜单按钮结束 -->				
			</div>
			<!-- 导航头部结束 -->
			<!-- 导航菜单开始 -->
			<div id="navMenu2" class="collapse navbar-collapse">
				<!-- 菜单列表开始 -->
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">菜单1</a></li>
					<li><a href="#">菜单2</a></li>
					<li><a href="#">新闻</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							菜单3
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">子菜单1</a></li>
							<li><a href="#">子菜单2</a></li>
						</ul>
					</li>
					<li><a href="#">菜单2</a></li>
					<li><a href="#">新闻</a></li>
					<li><a href="#">菜单2</a></li>
					<li><a href="#">新闻</a></li>
					<li><a href="#">菜单2</a></li>
					<li><a href="#">新闻</a></li>
				</ul>
				<!-- 菜单列表结束 -->				
			</div>
			<!-- 导航菜单结束 --> 
		</div>
		<!-- 内部容器结束 -->
	</nav>
	<!-- 导航条结束 -->