<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<title>xmlParser</title>
</head>
<body>
	<form method="POST" action="Messager" enctype="multipart/form-data">
		Your xml file<input type="file" name="path" value="upload" accept=".xml"><br><br>
		<button value="DOM" name="Button" type="submit">parse DOM</button>
		<button value="SAX" name="Button" type="submit">parse SAX</button>
		<button value="StAX" name="Button" type="submit">parse StAX</button>
	</form><br><br>
	<div class="table-responsive">
		<table class="table table-bordered table-hover table-condenced">
			<tr class="bg-light">
				<th>order's creation date</th>
				<th>order's payment date</th>
				<th>order's content</th>
				<th>client's email</th>
				<th>client's password</th>
				<th>client's role</th>
				<th>client's name</th>
				<th>client's surname</th>
				<th>client's registration date</th>
				<th>corporation's name</th>
				<th>corporation info</th>
				<th>client's status</th>
				<th>coach's email</th>
				<th>coach's password</th>
				<th>coach's role</th>
				<th>coach's name</th>
				<th>coach's surname</th>
				<th>coach's registration date</th>
				<th>coach's info</th>
				<th>subscription trainings quantity</th>
				<th>subscription payment date</th>
				<th>subscription expire date</th>
				<th>appointment's content</th>
				<th>appointment's rating</th>
				<th>appointment's comment</th>
				<th>appointment's creation date</th>
				<th>appointment's status</th>
			</tr>
			<c:forEach var="order" items="${orderList}">
				<tr>
					<td><c:out value="${order.creationDate}"/></td>
					<td><c:out value="${order.paymentDate}"/></td>
					<td><c:out value="${order.content}"/></td>
					<td><c:out value="${order.client.user.email}"/></td>
					<td><c:out value="${order.client.user.password}"/></td>
					<td><c:out value="${order.client.user.role}"/></td>
					<td><c:out value="${order.client.user.name}"/></td>
					<td><c:out value="${order.client.user.surname}"/></td>
					<td><c:out value="${order.client.user.registrationDate}"/></td>
					<td><c:out value="${order.client.corporation.name}"/></td>
					<td><c:out value="${order.client.corporation.corporationInfo}"/></td>
					<td><c:out value="${order.client.status}"/></td>
					<td><c:out value="${order.coach.user.email}"/></td>
					<td><c:out value="${order.coach.user.password}"/></td>
					<td><c:out value="${order.coach.user.role}"/></td>
					<td><c:out value="${order.coach.user.name}"/></td>
					<td><c:out value="${order.coach.user.surname}"/></td>
					<td><c:out value="${order.coach.user.registrationDate}"/></td>
					<td><c:out value="${order.coach.coachInfo}"/></td>
					<td><c:out value="${order.subscription.trainingsQuantity}"/></td>
					<td><c:out value="${order.subscription.paymentDate}"/></td>
					<td><c:out value="${order.subscription.expireDate}"/></td>
					<td>
						<table class="table table-hover table-condenced">
							<c:forEach var="appointment" items="${order.appointments}">
							<tr>
								<td>"${appointment.content}"
							</tr>
							</c:forEach>
						</table>
					</td>
					<td>
						<table class="table table-hover table-condenced">
							<c:forEach var="appointment" items="${order.appointments}">
								<tr>
									<td>"${appointment.rating}"
								</tr>
							</c:forEach>
						</table>
					</td>
					<td>
						<table class="table table-hover table-condenced">
							<c:forEach var="appointment" items="${order.appointments}">
								<tr>
									<td>"${appointment.comment}"
								</tr>
							</c:forEach>
						</table>
					</td>
					<td>
						<table class="table table-hover table-condenced">
							<c:forEach var="appointment" items="${order.appointments}">
								<tr>
									<td>"${appointment.creationDate}"
								</tr>
							</c:forEach>
						</table>
					</td>
					<td>
						<table class="table table-hover table-condenced">
							<c:forEach var="appointment" items="${order.appointments}">
								<tr>
									<td>"${appointment.status}"
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
