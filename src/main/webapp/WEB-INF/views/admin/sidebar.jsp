<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<c:url var='staff' value='/admin.htm' />
<c:url var='manageStaff' value='/admin/list-staff.htm' />
<c:url var='addStaff' value='/admin/add-staff.htm' />
<c:url var='disableCustomer' value='/admin/list-customer.htm' />
     <ul class='navbar-nav'>
        <li>
              <div class='nav-link px-3 py-0 active'>
                <span class='me-2'><i class='bi bi-speedometer2 fs-4'></i></span>
                <span class='fs-4'>Admin</span>
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
            <a class='nav-link px-3 sidebar-link' data-bs-toggle='collapse' href='#category-collapse'> <span class='me-2'><i
                        class='bi bi-box2-fill'></i></span> <span class='text-white' >Nhân viên</span> <span class='ms-auto'> <span
                        class='right-icon'> <i class='bi bi-chevron-down'></i>
                    </span>
                </span>
            </a>
            <div class='collapse' id='category-collapse'>
                <ul class='navbar-nav ps-3'>
                    <li>
                       <a href='${manageStaff}' class='nav-link px-3'> 
                         <span class='me-2'><i class='bi bi-speedometer2'></i></span>
                          <span class='text-white'>Quản lý nhân viên</span>
                       </a> 
                       <a href='${addStaff}' class='nav-link px-3'> 
                          <span class='me-2'><i class='bi bi-folder-plus'></i></span> 
                          <span class='text-white'>Thêm nhân viên</span>
                       </a>
                     </li>
                </ul>
            </div>
        </li>


        <li class='py-2'>
        	<a href='${disableCustomer}' class='nav-link px-3'> 
        		<span class='me-2'><i class="fa-solid fa-house"></i></span> 
        		<span class='text-white'>Khóa TK khách hàng</span>
            </a>
       </li>
       <li class='py-2'>
        	<a href='${staff}' class='nav-link px-3'> 
        		<span class='me-2'><i class="fa-solid fa-house"></i></span> 
        		<span class='text-white'>Trang chủ</span>
            </a>
       </li>
        <li class='py-2'>
        	<a href='${home}' class='nav-link px-3'> 
        		<span class='me-2'><i class="fa-solid fa-house"></i></span> 
        		<span class='text-white'>Hiệu chỉnh phiếu nhập</span>
            </a>
       </li>
        <li class='py-2'>
        	<a href='${home}' class='nav-link px-3'> 
        		<span class='me-2'><i class="fa-solid fa-house"></i></span> 
        		<span class='text-white'>Hiệu chỉnh phiếu xuất</span>
            </a>
       </li>
         <li class='py-2'>
        	<a href='${home}' class='nav-link px-3'> 
        		<span class='me-2'><i class="fa-solid fa-house"></i></span> 
        		<span class='text-white'>Hiệu chỉnh thanh toán</span>
            </a>
       </li>
    </ul> 
    
    