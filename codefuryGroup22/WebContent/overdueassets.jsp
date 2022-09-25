<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="adminstyle.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	 <div class="d-flex flex-column flex-lg-row h-lg-full bg-surface-secondary">
      <!-- Vertical Navbar -->
      <nav
        class="navbar show navbar-vertical h-lg-screen navbar-expand-lg px-0 py-3 navbar-light bg-white border-bottom border-bottom-lg-0 border-end-lg"
        id="navbarVertical"
      >
        <div class="container-fluid">
          <!-- Toggler -->
          <button
            class="navbar-toggler ms-n2"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#sidebarCollapse"
            aria-controls="sidebarCollapse"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <!-- Brand
          <a class="navbar-brand py-lg-2 mb-lg-5 px-lg-6 me-0" href="#">
            <img src="https://preview.webpixels.io/web/img/logos/clever-primary.svg" alt="..." />
          </a> -->
          <!-- User menu (mobile) -->
          <!-- Collapse -->
          <div class="collapse navbar-collapse" id="sidebarCollapse">
            <!-- Navigation -->
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="#"> <i class="bi bi-house"></i> Dashboard </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="addasset.html"> <i class="bi bi-plus-square-dotted"></i>Add Asset</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="GetNewAssetServlet"> <i class="bi bi-bookmarks"></i> Available Assets </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="OverdueManagementServlet"> <i class="bi bi-calendar-check"></i> Overdue Assets </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#"> <i class="bi bi-people"></i> Users </a>
              </li>
            </ul>
            <!-- Divider -->
            <hr class="navbar-divider my-5 opacity-20" />

            <!-- Push content down -->
            <div class="mt-auto"></div>
            <!-- User (md) -->
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="#"> <i class="bi bi-person-square"></i> Account </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="logout"> <i class="bi bi-box-arrow-left"></i> Logout </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- Main content -->
      <div class="h-screen flex-grow-1 overflow-y-lg-auto">
        <!-- Header -->
        <header class="bg-surface-primary border-bottom pt-6">
          <div class="container-fluid">
            <div class="mb-npx">
              <div class="row align-items-center">
                <div class="col-sm-6 col-12 mb-4 mb-sm-0">
                  <!-- Title -->
                  <h1 class="h2 mb-0 ls-tight">E-Asset Management</h1>
                </div>
                <!-- Actions -->
                
              </div>
              <!-- Nav -->
              <ul class="nav nav-tabs mt-4 overflow-x border-0">
                <li class="nav-item">
                  <a href="#" class="nav-link active" style="color: black">All Assets</a>
                </li>
                <li class="nav-item">
                  <a href="addasset.html" class="nav-link font-regular" style="color: black">Add Assets</a>
                </li>
                <li class="nav-item">
                  <a href="OverdueManagementServlet" class="nav-link font-regular" style="color: black">Overdue Asset management</a>
                </li>
              </ul>
            </div>
          </div>
        </header>
        <!-- Main -->
        <main class="py-6 bg-surface-secondary">
          <div class="container-fluid">
            <!-- Card stats -->
            <div class="row g-6 mb-6">              
            <div class="card shadow border-0 mb-7">
              <div class="card-header">
                <h5 class="mb-0">Applications</h5>
              </div>
              <!-- Can use Ajax to populate this table -->
              <div class="table-responsive">
              	<% JSONArray ja= (JSONArray)request.getAttribute("jsonOb"); %>
                <table class="table table-hover table-nowrap">
                  <thead class="thead-light">
			 		<tr>
			 			<th>UserID</th>
			 			<th>UserName</th>
			 			<th>AssetID</th>
			 			<th>AssetName</th>
			 			<th>Type</th>
			 			<th>Period</th>
			 			<th>DaysBan</th>
			 			<th>Create Message</th>
			 		</tr>
	 			</thead>
	 			<tbody>
				    <%  for(int i=0;i<ja.length();i++) 
						{
							JSONObject rec = ja.getJSONObject(i);
							int userId = rec.getInt("uid");
						 	String userName = rec.getString("uname");
						 	int assetId = rec.getInt("assetid");
						 	String assetName = rec.getString("assetname");
						 	String type = rec.getString("type");
						 	int period = rec.getInt("period");
						 	int daysBan = rec.getInt("days_ban");	
					%>
						<tr><td><%= userId %></td>
							<td><%= userName %></td>
							<td><%= assetId %></td>
							<td><%= assetName %></td>
							<td><%= type %></td>
							<td><%= period %></td>
							<td><%= daysBan %></td>
							<td>
								<form name="sendmessage" action="MessageServlet" onsubmit = "return true">
									<input type="text" name="messageInp" id="messageid" />
									<input type="hidden" name="userId" value=<%=userId %> />
									<input type="hidden" name="assetId" value=<%=assetId %> />
									<input type="submit" value="Send"/>
								</form>
							</td></tr>
					 <%
						}
					 %> 
				</tbody>
				</table>
              </div>
              <div class="card-footer border-0 py-5">
                <span class="text-muted text-sm">Showing 10 items out of 250 results found</span>
              </div>
            </div>
          </div>
        </main>
      </div>
    </div>
</body>

</html>