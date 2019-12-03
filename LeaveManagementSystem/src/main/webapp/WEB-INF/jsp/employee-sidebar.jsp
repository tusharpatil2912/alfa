<div class="row" style="min-height: 400px;">
            <div class="col-md-3">
                <!-- sidebar -->
                <img src="assets/images/employee.png" alt="admin" class="img-thumbnail rounded mx-auto d-block"/>
				<hr/>
                <a class="btn btn-block btn-primary" href="./employee-dashboard">Dashboard</a>
                <a class="btn btn-block btn-primary" href="./apply-leave">Apply For Leave</a>
                <a class="btn btn-block btn-primary" href="./leave-history">Leave History</a>
                <hr/>
                <div class="alert alert-success" role="alert">
  					<h4 class="alert-heading">Available Leaves : ${employee.available}</h4>
  				</div>
  				<hr/>
                <a class="btn btn-block btn-danger" href="./employee-logout">Logout</a>
                
            </div>
            <div class="col-md-9">