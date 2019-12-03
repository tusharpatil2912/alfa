<%@ include file="./header.jsp"%>
<%@ include file="./sidebar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8 col-sm-12">

		<h3>${title} Login</h3>
		<hr />
		
		
		<form method="POST">

			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input autofocus="autofocus" type="text" class="form-control"
						id="email" name="email">
				</div>
			</div>

			<div class="form-group row">
				<label for="password"  class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<input autofocus="autofocus" type="password" class="form-control"
						id="password" name="password">
				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2 col-form-label"></label>
				<div class="col-sm-10">
					<button class="btn btn-primary">Login</button>
					<a href="./" class="btn btn-link">Cancel</a>
				</div>
			</div>

		</form>
		
		<h2 class="text-danger">${errMsg}</h2>
	</div>
	<div class="col-md-2"></div>
</div>

<%@ include file="./footer.jsp"%>