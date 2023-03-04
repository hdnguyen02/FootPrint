<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div
      class="offcanvas offcanvas-start sidebar-nav bg-dark shadow-lg" data-bs-scroll="true" style="background-color: #4e73df !important" tabindex="-1" id="sidebar-dashboard">
      <div class="offcanvas-body">
        <nav class="navbar-dark">
        
        <!-- Nội dung sidebar-dashboad  -->
        <jsp:include page="/WEB-INF/views/${ sidebarDashboard }" />
         <!-- Nội dung sidebar-dashboad  -->
        </nav>
      </div>
    </div>