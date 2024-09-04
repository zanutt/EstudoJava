<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body>

	<!-- Pre-loader start -->
	<jsp:include page="theme-loader.jsp"></jsp:include>

	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<jsp:include page="navbar.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="navbarmainmenu.jsp"></jsp:include>

					<div class="pcoded-content">
						<!-- Page-header start -->
						<jsp:include page="page-header.jsp"></jsp:include>
						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">
										<div class="row">
											<form>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Simple Input</label>
													<div class="col-sm-10">
														<input type="text" class="form-control">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Placeholder</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															placeholder="Type your title in Placeholder">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Password</label>
													<div class="col-sm-10">
														<input type="password" class="form-control"
															placeholder="Password input">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Read only</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															placeholder="You can't change me" readonly>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Disable
														Input</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															placeholder="Disabled text" disabled>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Predefine
														Input</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															value="Enter yout content after me">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Select Box</label>
													<div class="col-sm-10">
														<select name="select" class="form-control">
															<option value="opt1">Select One Value Only</option>
															<option value="opt2">Type 2</option>
															<option value="opt3">Type 3</option>
															<option value="opt4">Type 4</option>
															<option value="opt5">Type 5</option>
															<option value="opt6">Type 6</option>
															<option value="opt7">Type 7</option>
															<option value="opt8">Type 8</option>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Round Input</label>
													<div class="col-sm-10">
														<input type="text" class="form-control form-control-round"
															placeholder=".form-control-round">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Maximum
														Length</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															placeholder="Content must be in 6 characters"
															maxlength="6">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Disable
														Autocomplete</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
															placeholder="Autocomplete Off" autocomplete="off">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Static Text</label>
													<div class="col-sm-10">
														<div class="form-control-static">Hello !... This is
															static text</div>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Color</label>
													<div class="col-sm-10">
														<input type="color" class="form-control">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Upload File</label>
													<div class="col-sm-10">
														<input type="file" class="form-control">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Textarea</label>
													<div class="col-sm-10">
														<textarea rows="5" cols="5" class="form-control"
															placeholder="Default textarea"></textarea>
													</div>
												</div>
											</form>
										</div>
									</div>
									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Required Jquery -->
	<jsp:include page="javascriptfile.jsp"></jsp:include>
</body>

</html>
