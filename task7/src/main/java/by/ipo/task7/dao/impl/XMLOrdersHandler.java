package by.ipo.task7.dao.impl;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.ipo.task7.bean.Appointment;
import by.ipo.task7.bean.Client;
import by.ipo.task7.bean.Coach;
import by.ipo.task7.bean.Corporation;
import by.ipo.task7.bean.Order;
import by.ipo.task7.bean.Subscription;
import by.ipo.task7.bean.User;

/**
 * This class represents orders handler for SAX parser
 * 
 * @author Pavel Isidovich
 * @see Order
 */
public class XMLOrdersHandler extends DefaultHandler {

	/** Data fields */
	private List<Order> orderList;
	private String currentElement;
	private boolean userFlag;
	private boolean clientFlag;
	private boolean corporationFlag;
	private boolean coachFlag;
	private boolean subscriptionFlag;
	private boolean appointmentFlag;
	private User user = new User.Builder().build();
	private Client client = new Client.Builder().build();
	private Corporation corporation = new Corporation.Builder().build();
	private Coach coach = new Coach.Builder().build();
	private Subscription subscription = new Subscription.Builder().build();
	private Appointment appointment = new Appointment.Builder().build();
	private Order order = new Order.Builder().build();
	private StringBuilder input = new StringBuilder("");

	/**
	 * This constructor creates new handler with entered list link.
	 * 
	 * @param orderList - link to target list
	 */
	public XMLOrdersHandler(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		this.currentElement = qName;
		this.input = new StringBuilder("");

		switch (qName) {

		case "order":
			this.order = new Order.Builder().build();
			break;

		case "user":
			this.user = new User.Builder().build();
			this.userFlag = true;
			break;

		case "client":
			this.client = new Client.Builder().build();
			this.clientFlag = true;
			break;

		case "corporation":
			this.corporation = new Corporation.Builder().build();
			this.corporationFlag = true;
			break;

		case "coach":
			this.coach = new Coach.Builder().build();
			this.coachFlag = true;
			break;

		case "subscription":
			this.subscription = new Subscription.Builder().build();
			this.subscriptionFlag = true;
			break;

		case "appointment":
			this.appointment = new Appointment.Builder().build();
			this.appointmentFlag = true;
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		switch (qName) {

		case "order":
			this.orderList.add(this.order);
			break;

		case "user":
			if (this.clientFlag && !this.coachFlag) {
				this.client.setUser(this.user);
			} else if (this.coachFlag & !this.clientFlag) {
				this.coach.setUser(this.user);
			}
			this.userFlag = false;
			break;

		case "client":
			this.order.setClient(this.client);
			this.clientFlag = false;
			break;

		case "corporation":
			this.client.setCorporation(this.corporation);
			this.corporationFlag = false;
			break;

		case "coach":
			this.order.setCoach(this.coach);
			this.coachFlag = false;
			break;

		case "subscription":
			this.order.setSubscription(this.subscription);
			this.subscriptionFlag = false;
			break;

		case "appointment":
			this.order.addAppointment(this.appointment);
			this.appointmentFlag = false;
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		this.input.append(ch, start, length);

		switch (this.currentElement) {

		case "creation_date":
			if (this.appointmentFlag) {
				this.appointment.setCreationDate(input.toString().strip());
			} else {
				this.order.setCreationDate(input.toString().strip());
			}
			break;

		case "payment_date":
			if (this.subscriptionFlag) {
				this.subscription.setPaymentDate(input.toString().strip());
			} else {
				this.order.setPaymentDate(input.toString().strip());
			}
			break;

		case "content":
			if (this.appointmentFlag) {
				this.appointment.setContent(input.toString().strip());
			} else {
				this.order.setContent(input.toString().strip());
			}
			break;

		case "email":
			this.user.setEmail(input.toString().strip());
			break;

		case "password":
			this.user.setPassword(input.toString().strip());
			break;

		case "role":
			this.user.setRole(input.toString().strip());
			break;

		case "name":
			if (this.userFlag && !this.corporationFlag) {
				this.user.setName(input.toString().strip());
			} else if (this.corporationFlag && !this.userFlag) {
				this.corporation.setName(input.toString().strip());
			}
			break;

		case "surname":
			this.user.setSurname(input.toString().strip());
			break;

		case "registration_date":
			this.user.setRegistrationDate(input.toString().strip());
			break;

		case "corporation_info":
			this.corporation.setCorporationInfo(input.toString().strip());
			break;

		case "status":
			if (this.clientFlag && !this.appointmentFlag) {
				this.client.setStatus(input.toString().strip());
			} else if (this.appointmentFlag && !this.clientFlag) {
				this.appointment.setStatus(input.toString().strip());
			}
			break;

		case "coach_info":
			this.coach.setCoachInfo(input.toString().strip());
			break;

		case "trainings_quantity":
			this.subscription.setTrainingsQuantity(
					Integer.parseInt(input.toString().strip()));
			break;

		case "expire_date":
			this.subscription.setExpireDate(input.toString().strip());
			break;

		case "rating":
			this.appointment
					.setRating(Integer.parseInt(input.toString().strip()));
			break;

		case "comment":
			this.appointment.setComment(input.toString().strip());
			break;
		}
	}

}
