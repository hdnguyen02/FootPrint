<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<c:url var='addProduct' value='/staff/add-product.htm'/>
<c:url var='importProduct' value='/staff/import-product.htm'/>
<c:url var='exportProduct' value='/staff/export-product.htm'/>
<c:url var='manageCategory' value='/staff/list-category.htm'/>
<c:url var='listImport' value='/staff/list-import.htm'/>
<c:url var='addCategory' value='/staff/add-category.htm' />
<c:url var='manageProduct' value='/staff/list-product.htm' />
<c:url var='listExport' value='/staff/list-export.htm' />
<c:url var='order' value='/staff/order.htm' />
<c:url var='home' value='/' />
<c:url var='staff' value='/staff.htm' />
 <c:url var='addPayment' value='/staff/payment.htm' />
 <c:url var='listPayment' value='/staff/list-payment.htm' />
  <c:url var='signOut' value='/sign-out.htm' />

     <ul class='navbar-nav' style="font-size: 15px">
        <li>
              <div class='nav-link px-3 py-0 active'>
                <span class='me-2'><i class='bi bi-speedometer2 fs-4'></i></span>
                <span class='fs-4'>Staff</span>
              </div>
            </li>
            <li><hr style='margin-top:16px; margin-bottom:22px;color: white !important'/>
         </li>
       <li class='py-2'>
        	<a href='${staff}' class='nav-link px-3'> 
        		<span class='me-2'><i class="fa-solid fa-industry"></i></span> 
        		<span class='text-white'>Tổng quan</span>
            </a>
       </li>
        <li class='py-2'>
            <a class='nav-link px-3 sidebar-link' data-bs-toggle='collapse' href='#product-collapse'> <span class='me-2'><i
                        class='bi bi-box2-fill'></i></span> <span class='text-white' >Sản phẩm</span> <span class='ms-auto'> <span
                        class='right-icon'> <i class='bi bi-chevron-down'></i>
                    </span>
                </span>
            </a>
            <div class='collapse' id='product-collapse'>
                <ul class='navbar-nav ps-3'>
                    <li>
                       <a href='${manageProduct}' class='nav-link px-3'> 
                         <span class='me-2'><i class='bi bi-speedometer2'></i></span>
                          <span class='text-white'>Quản lý sản phẩm</span>
                       </a> 
                       <a href='${addProduct}' class='nav-link px-3'> 
                          <span class='me-2'><i class='fa fa-plus'></i></span> 
                          <span class='text-white'>Thêm sản phẩm</span>
                       </a>
              
                     </li>
                </ul>
            </div>
        </li>
        
        
        
         <li class='py-2'>
            <a class='nav-link px-3 sidebar-link' data-bs-toggle='collapse' href='#category-collapse'> <span class='me-2'><i
                        class='fa fa-paper-plane'></i></span> <span class='text-white' >Danh mục sản phẩm</span> <span class='ms-auto'> <span
                        class='right-icon'> <i class='bi bi-chevron-down'></i>
                    </span>
                </span>
            </a>
            <div class='collapse' id='category-collapse'>
                <ul class='navbar-nav ps-3'>
                    <li>
                       <a href='${manageCategory}' class='nav-link px-3'> 
                         <span class='me-2'><i class='fa fa-list-alt'></i></span>
                          <span class='text-white'>Danh sách danh mục</span>
                       </a> 
                       <a href='${addCategory}' class='nav-link px-3'> 
                          <span class='me-2'><i class='fa fa-plus'></i></span> 
                          <span class='text-white'>Thêm danh mục</span>
                       </a>
                     </li>
                </ul>
            </div>
        </li>

        <li class='py-2'>
            <a class='nav-link px-3 sidebar-link' data-bs-toggle='collapse' href='#import-collapse'> 
            	<span class='me-2'><i
                        class='fa fa-cloud-download'></i></span> <span class='text-white' >Nhập hàng</span> <span class='ms-auto'> <span
                        class='right-icon'> <i class='bi bi-chevron-down'></i>
                    </span>
                </span>
            </a>
            <div class='collapse' id='import-collapse'>
                <ul class='navbar-nav ps-3'>
                    <li>
                       <a href='${listImport}' class='nav-link px-3'> 
                          <span class='me-2'><i class='fa fa-list-alt'></i></span> 
                          <span class='text-white'>Danh sách Phiếu nhập</span>
                       </a>
                       <a href='${importProduct}' class='nav-link px-3'> 
			                <span class='me-2'><i class='fa fa-plus'></i></span> 
			                <span class='text-white'>Thêm Phiếu nhập</span>
             			</a>
                     </li>
                </ul>
            </div>
        </li>
        
         <li class='py-2'>
            <a class='nav-link px-3 sidebar-link' data-bs-toggle='collapse' href='#export-collapse'> 
            	<span class='me-2'><i
                        class='fa fa-truck'></i></span> <span class='text-white' >Xuất hàng</span> <span class='ms-auto'> <span
                        class='right-icon'> <i class='bi bi-chevron-down'></i>
                    </span>
                </span>
            </a>
            <div class='collapse' id='export-collapse'>
                <ul class='navbar-nav ps-3'>
                    <li>
                       <a href='${listExport}' class='nav-link px-3'> 
                          <span class='me-2'><i class='fa fa-list-alt'></i></span> 
                          <span class='text-white'>Danh sách Phiếu xuất</span>
                       </a>
                       <a href='${exportProduct}' class='nav-link px-3'> 
			                <span class='me-2'><i class='fa fa-plus'></i></span> 
			                <span class='text-white'>Thêm Phiếu xuất</span>
             			</a>
                     </li>
                </ul>
            </div>
        </li>
        
         <li class='py-2'>
            <a class='nav-link px-3 sidebar-link' data-bs-toggle='collapse' href='#payment-collapse'> 
            	<span class='me-2'><i
                        class='fa fa-truck'></i></span> <span class='text-white' >Thanh toán</span> <span class='ms-auto'> <span
                        class='right-icon'> <i class='bi bi-chevron-down'></i>
                    </span>
                </span>
            </a>
            <div class='collapse' id='payment-collapse'>
                <ul class='navbar-nav ps-3'>
                    <li>
                       <a href='${listPayment}' class='nav-link px-3'> 
                          <span class='me-2'><i class='fa fa-list-alt'></i></span> 
                          <span class='text-white'>Danh sách thanh toán</span>
                       </a>
                       <a href='${addPayment}' class='nav-link px-3'> 
			                <span class='me-2'><i class='fa fa-plus'></i></span> 
			                <span class='text-white'>Thêm thanh toán</span>
             			</a>
                     </li>
                </ul>
            </div>
        </li>

        <li class='py-2'>
        	<a href='${order}' class='nav-link px-3'> 
        		<span class='me-2'><i class='bi bi-cart'></i></span> 
        		<span class='text-white'>Đơn đặt hàng</span>
            </a>
       </li>
       
       
       
       
       <li class='py-2'>
        	<a href='${home}' class='nav-link px-3'> 
        		<span class='me-2'><i class="fa-solid fa-house"></i></span> 
        		<span class='text-white'>Trang chủ</span>
            </a>
       </li>
       <li class='py-2'>
        	<a href='${signOut}' class='nav-link px-3'> 
        		<span class='me-2'><i class="fa fa-sign-out"></i></span> 
        		<span class='text-white'>Đăng xuất</span>
            </a>
       </li>
    </ul> 
    
    