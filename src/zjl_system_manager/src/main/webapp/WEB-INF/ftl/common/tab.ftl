<#macro tab index>
<nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="http://orheaidcn.bkt.clouddn.com/profile_small.jpg"/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">Beaut-zihan</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li>
                                <a class="J_menuItem" href="form_avatar.html">修改头像</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="profile.html">个人资料</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="contacts.html">联系我们</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="mailbox.html">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="login.html">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">H+
                    </div>
                </li>
                
                <#list menus as menu>
                	  <!--两个问号??表示 如果菜单的子菜单不为空 -->
                	   <#if menu.children??>
	                     	 <li>
		                        <a href="#">
		                            <i class="fa ${menu.icon}"></i>
		                            <span class="nav-label">${menu.menuName}</span>
		                            <span class="fa arrow"></span>
		                        </a>
			                      <ul class="nav nav-second-level">
			                            <#list menu.children as subMenu>
			                             <#if subMenu.children??>
			                            	  <li>
			                            	    <i class="fa ${menu.icon}"></i>
		                                        <a href="#">${subMenu.name} <span class="fa arrow"></span></a>
		                                        <ul class="nav nav-third-level">
		                                           <#list subMenu.children as thirdMenu>
		                                            <li>
			                                             <a>
				                                             <i class="fa ${menu.icon}"></i>
				                                              <span class="J_menuItem" id="${thirdMenu.id}" href="${contextPath}${thirdMenu.menuUrl}/${subMenu.id}" name="tabMenuItem">${thirdMenu.menuName}</span>
			                                              </a>
		                                            </li>
		                                            </#list>
		                                        </ul>
		                                     </li>
		                                  <#else>
				                              <li>
		                                         <a>
		                                          <i class="fa ${menu.icon}"></i>
		                                          <span class="J_menuItem" id="${subMenu.id}"  href="${contextPath}${subMenu.menuUrl}?menuId=${subMenu.id}" name="tabMenuItem">${subMenu.menuName}</span></a>
		                                      </li>
		                            	 </#if>
			                            </#list>
		                        </ul>				
		                    </li>
			      	   <#else>
			      	    <li>
	                        <a class="J_menuItem"  id="${menu.id}" href="${contextPath}${menu.menuUrl}/${subMenu.id}"" name="tabMenuItem">
	                            <i class="fa ${menu.icon}"></i>
	                            <span class="nav-label">${menu.menuName}</span>
	                        </a>
	                     </li>
      				 </#if>
                </#list>  
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
  </#macro>