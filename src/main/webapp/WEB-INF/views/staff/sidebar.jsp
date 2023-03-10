<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="addProduct" value="/staff/product/add.htm" />
<c:url var="listProduct" value="/staff/product/list.htm" />
<c:url var="categoryProduct" value="/staff/category.htm" />



     <ul class="navbar-nav">

        <li>
              <div class="nav-link px-3 active">
                <span class="me-2"><i class="bi bi-speedometer2 fs-4"></i></span>
                <span class="fs-4">Dashboard</span>
              </div>
            </li>
            <li><hr style="margin-top:14px; margin-bottom:22px"/></li>

        <li>
            <a class="nav-link px-3 sidebar-link" data-bs-toggle="collapse" href="#product-collapse"> <span class="me-2"><i
                        class="bi bi-box2-fill"></i></span> <span class="text-white" >Sản phẩm</span> <span class="ms-auto"> <span
                        class="right-icon"> <i class="bi bi-chevron-down"></i>
                    </span>
                </span>
            </a>
            <div class="collapse" id="product-collapse">
                <ul class="navbar-nav ps-3">
                    <li>
                    
                       <a href="${addProduct}" class="nav-link px-3"> 
                         <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                          <span class="text-white">Danh sách sản phẩm</span>
                       </a> 
                       <a href='add-product.htm' class="nav-link px-3"> 
                          <span class="me-2"><i class="bi bi-folder-plus"></i></span> 
                          <span class="text-white">Thêm sản phẩm</span>
                       </a>
                     </li>
                </ul>
            </div>
        </li>

        <li>
            <hr />
        </li>
        
        <li>
        	<a href="${ categoryProduct }" class="nav-link px-3"> 
        		<span class="me-2"><i class="bi bi-cart"></i></span> 
        		<span class="text-white">Danh mục sản phẩm</span>
            </a>
       </li>
       
       <li>
            <hr />
        </li>

        <li>
        	<a href="#" class="nav-link px-3"> 
        		<span class="me-2"><i class="bi bi-cart"></i></span> 
        		<span class="text-white">Đơn hàng</span>
            </a>
       </li>
    </ul> 
    
    