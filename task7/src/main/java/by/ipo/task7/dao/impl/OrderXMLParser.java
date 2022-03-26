package by.ipo.task7.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.logging.log4j.LogManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.ipo.task7.bean.Appointment;
import by.ipo.task7.bean.Client;
import by.ipo.task7.bean.Coach;
import by.ipo.task7.bean.Corporation;
import by.ipo.task7.bean.Order;
import by.ipo.task7.bean.Subscription;
import by.ipo.task7.bean.User;
import by.ipo.task7.dao.ObjectXMLParser;
import by.ipo.task7.dao.exception.FileAccessException;
import by.ipo.task7.dao.exception.XMLValidationException;

/**
 * This class provides methods to parse client-objects via different parsers
 * 
 * @author Pavel Isidovich
 * @see Client
 */
public class OrderXMLParser implements ObjectXMLParser<Order> {

	private XMLOrdersValidator xov = new XMLOrdersValidator();
	private static org.apache.logging.log4j.Logger logger = LogManager
			.getFormatterLogger();

	@Override
	public List<Order> parseDOM(String path)
			throws XMLValidationException, FileAccessException {
		try {
			if (!this.xov.validate(path)) {
				logger.debug("Документ '" + path + "' не соответствует схеме");
				throw new XMLValidationException();
			}

			Document doc = null;
			try {
				doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
						.parse(new File(path));
				logger.trace("Данные получены");
			} catch (SAXException e) {
				e.printStackTrace();
			}

			List<Order> orders = new ArrayList<>();
			NodeList rawOrders = doc.getDocumentElement()
					.getElementsByTagName("order");

			for (int i = 0; i < rawOrders.getLength(); ++i) {
				Element e = (Element) rawOrders.item(i);

				orders.add(new Order.Builder()
						.withClient(new Client.Builder()
								.withUser(new User.Builder()
										.withEmail(((Element) e
												.getElementsByTagName("client")
												.item(0))
														.getElementsByTagName(
																"email")
														.item(0)
														.getTextContent())
										.withName(((Element) e
												.getElementsByTagName("client")
												.item(0))
														.getElementsByTagName(
																"name")
														.item(0)
														.getTextContent())
										.withPassword(((Element) e
												.getElementsByTagName("client")
												.item(0))
														.getElementsByTagName(
																"password")
														.item(0)
														.getTextContent())
										.withRegistrationDate(((Element) e
												.getElementsByTagName("client")
												.item(0)).getElementsByTagName(
														"registration_date")
														.item(0)
														.getTextContent())
										.withSurname(((Element) e
												.getElementsByTagName("client")
												.item(0))
														.getElementsByTagName(
																"surname")
														.item(0)
														.getTextContent())
										.withRole(((Element) e
												.getElementsByTagName("client")
												.item(0))
														.getElementsByTagName(
																"role")
														.item(0)
														.getTextContent())
										.build())
								.withStatus(((Element) e
										.getElementsByTagName("client").item(0))
												.getElementsByTagName("status")
												.item(0).getTextContent())
								.withCorporation(new Corporation.Builder()
										.withName(((Element) e
												.getElementsByTagName(
														"corporation")
												.item(0))
														.getElementsByTagName(
																"name")
														.item(0)
														.getTextContent())
										.withCorporationInfo(((Element) e
												.getElementsByTagName("client")
												.item(0)).getElementsByTagName(
														"corporation_info")
														.item(0)
														.getTextContent())
										.build())
								.build())
						.withCoach(new Coach.Builder()
								.withUser(new User.Builder()
										.withEmail(((Element) e
												.getElementsByTagName("coach")
												.item(0))
														.getElementsByTagName(
																"email")
														.item(0)
														.getTextContent())
										.withName(((Element) e
												.getElementsByTagName("coach")
												.item(0))
														.getElementsByTagName(
																"name")
														.item(0)
														.getTextContent())
										.withPassword(((Element) e
												.getElementsByTagName("coach")
												.item(0))
														.getElementsByTagName(
																"password")
														.item(0)
														.getTextContent())
										.withRegistrationDate(((Element) e
												.getElementsByTagName("coach")
												.item(0)).getElementsByTagName(
														"registration_date")
														.item(0)
														.getTextContent())
										.withSurname(((Element) e
												.getElementsByTagName("coach")
												.item(0))
														.getElementsByTagName(
																"surname")
														.item(0)
														.getTextContent())
										.withRole(((Element) e
												.getElementsByTagName("coach")
												.item(0))
														.getElementsByTagName(
																"role")
														.item(0)
														.getTextContent())
										.build())
								.withCoachInfo(((Element) e
										.getElementsByTagName("coach").item(0))
												.getElementsByTagName(
														"coach_info")
												.item(0).getTextContent())
								.build())
						.withSubscription(
								new Subscription.Builder()
										.withExpireDate(((Element) e
												.getElementsByTagName(
														"subscription")
												.item(0))
														.getElementsByTagName(
																"expire_date")
														.item(0)
														.getTextContent())
										.withPaymentDate(((Element) e
												.getElementsByTagName(
														"subscription")
												.item(0))
														.getElementsByTagName(
																"payment_date")
														.item(0)
														.getTextContent())
										.withTrainingsQuantity(
												Integer.parseInt(((Element) e
														.getElementsByTagName(
																"subscription")
														.item(0))
																.getElementsByTagName(
																		"trainings_quantity")
																.item(0)
																.getTextContent()))
										.build())
						.withCreationDate(
								e.getElementsByTagName("creation_date").item(0)
										.getTextContent())
						.withContent(e.getElementsByTagName("content").item(0)
								.getTextContent())
						.withPaymentDate(e.getElementsByTagName("payment_date")
								.item(0).getTextContent())
						.build());

				NodeList rawAppointments = e
						.getElementsByTagName("appointment");

				for (int j = 0; j < rawAppointments.getLength(); ++j) {
					orders.get(i).addAppointment(
							new Appointment.Builder()
									.withComment(
											((Element) rawAppointments.item(j))
													.getElementsByTagName(
															"comment")
													.item(0).getTextContent())
									.withContent(
											((Element) rawAppointments.item(j))
													.getElementsByTagName(
															"content")
													.item(0).getTextContent())
									.withCreationDate(
											((Element) rawAppointments.item(j))
													.getElementsByTagName(
															"creation_date")
													.item(0).getTextContent())
									.withRating(Integer.parseInt(
											((Element) rawAppointments.item(j))
													.getElementsByTagName(
															"rating")
													.item(0).getTextContent()))
									.withStatus(
											((Element) rawAppointments.item(j))
													.getElementsByTagName(
															"status")
													.item(0).getTextContent())
									.build());
				}
			}

			logger.trace("Отсет отправлен");

			return orders;
		} catch (ParserConfigurationException e) {
			logger.fatal("Ошибка парсинга");
		} catch (IOException e) {
			logger.error("Файл '" + path + "' недоступен или отсутствует");
			throw new FileAccessException();
		}
		return null;
	}

	@Override
	public List<Order> parseSAX(String path)
			throws XMLValidationException, FileAccessException {
		try {
			if (!this.xov.validate(path)) {
				logger.debug("Документ '" + path + "' не соответствует схеме");
				throw new XMLValidationException();
			}

			logger.trace("Данные получены");

			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			List<Order> orders = new ArrayList<>();

			sp.parse(new File(path), new XMLOrdersHandler(orders));

			logger.trace("Данные отправлены");

			return orders;
		} catch (IOException e) {
			logger.error("Файл '" + path + "' недоступен или отсутствует");
			throw new FileAccessException();
		} catch (ParserConfigurationException | SAXException e) {
			logger.fatal("Ошибка парсинга");
		}

		return null;
	}

	@Override
	public List<Order> parseStAX(String path)
			throws XMLValidationException, FileAccessException {

		try {
			if (!this.xov.validate(path)) {
				logger.debug("Документ '" + path + "' не соответствует схеме");
				throw new XMLValidationException();
			}

			logger.trace("Данные получены");

			List<Order> orders = new ArrayList<>();

			XMLStreamReader xsr = XMLInputFactory.newInstance()
					.createXMLStreamReader(new FileInputStream(new File(path)));
			
			boolean userFlag = false;
			boolean clientFlag = false;
			boolean corporationFlag = false;
			boolean coachFlag = false;
			boolean subscriptionFlag = false;
			boolean appointmentFlag = false;
			User user = new User.Builder().build();
			Client client = new Client.Builder().build();
			Corporation corporation = new Corporation.Builder().build();
			Coach coach = new Coach.Builder().build();
			Subscription subscription = new Subscription.Builder().build();
			Appointment appointment = new Appointment.Builder().build();
			Order order = new Order.Builder().build();
			
			while (xsr.hasNext()) {
				xsr.next();
				switch (xsr.getEventType()) {
				
				case XMLStreamConstants.START_ELEMENT:
					switch (xsr.getName().getLocalPart()) {
					
					case "client":
						clientFlag = true;
						client = new Client.Builder().build();
						break;
						
					case "user":
						userFlag = true;
						user = new User.Builder().build();
						break;
						
					case "order":
						order = new Order.Builder().build();
						break;
						
					case "corporation":
						corporation = new Corporation.Builder().build();
						corporationFlag = true;
						break;
						
					case "coach":
						coach = new Coach.Builder().build();
						coachFlag = true;
						break;
						
					case "subscription":
						subscription = new Subscription.Builder().build();
						subscriptionFlag = true;
						break;
						
					case "appointment":
						appointment = new Appointment.Builder().build();
						appointmentFlag = true;
						break;
						
					case "creation_date":
						xsr.next();
						if (appointmentFlag) {
							appointment.setCreationDate(xsr.getText());
						} else {
							order.setCreationDate(xsr.getText());
						}
						break;
						
					case "payment_date":
						xsr.next();
						if (subscriptionFlag) {
							subscription.setPaymentDate(xsr.getText());
						} else {
							order.setPaymentDate(xsr.getText());
						}
						break;

					case "content":
						xsr.next();
						if (appointmentFlag) {
							appointment.setContent(xsr.getText());
						} else {
							order.setContent(xsr.getText());
						}
						break;

					case "email":
						xsr.next();
						user.setEmail(xsr.getText());
						break;

					case "password":
						xsr.next();
						user.setPassword(xsr.getText());
						break;

					case "role":
						xsr.next();
						user.setRole(xsr.getText());
						break;

					case "name":
						xsr.next();
						if (userFlag && !corporationFlag) {
							user.setName(xsr.getText());
						} else if (corporationFlag && !userFlag) {
							corporation.setName(xsr.getText());
						}
						break;

					case "surname":
						xsr.next();
						user.setSurname(xsr.getText());
						break;

					case "registration_date":
						xsr.next();
						user.setRegistrationDate(xsr.getText());
						break;

					case "corporation_info":
						xsr.next();
						corporation.setCorporationInfo(xsr.getText());
						break;

					case "status":
						xsr.next();
						if (clientFlag && !appointmentFlag) {
							client.setStatus(xsr.getText());
						} else if (appointmentFlag && !clientFlag) {
							appointment.setStatus(xsr.getText());
						}
						break;

					case "coach_info":
						xsr.next();
						coach.setCoachInfo(xsr.getText());
						break;


					case "trainings_quantity":
						xsr.next();
						subscription.setTrainingsQuantity(
								Integer.parseInt(xsr.getText()));
						break;

					case "expire_date":
						xsr.next();
						subscription.setExpireDate(xsr.getText());
						break;


					case "rating":
						xsr.next();
						appointment.setRating(Integer.parseInt(xsr.getText()));
						break;
						
					case "comment":
						xsr.next();
						appointment.setComment(xsr.getText());
						break;
					}
					break;
					
				case XMLStreamConstants.END_ELEMENT:
					switch(xsr.getName().getLocalPart()) {
					
					case "client":
						order.setClient(client);
						clientFlag = false;
						break;
						
					case "user":
						if (!coachFlag && clientFlag) {
							client.setUser(user);
							userFlag = false;
						} else if (!clientFlag && coachFlag) {
							coach.setUser(user);
							userFlag = false;
						}
						break;
						
					case "order":
						orders.add(order);
						break;
						
					case "corporation":
						client.setCorporation(corporation);
						corporationFlag = false;
						break;
						
					case "coach":
						order.setCoach(coach);
						coachFlag = false;
						break;
						
					case "subscription":
						order.setSubscription(subscription);
						subscriptionFlag = false;
						break;
						
					case "appointment":
						order.addAppointment(appointment);
						appointmentFlag = false;
						break;
					}
					break;
				}
			}

			xsr.close();
			
			return orders;
			
		} catch (IOException e) {
			logger.error("Файл '" + path + "' недоступен или отсутствует");
			throw new FileAccessException();
		} catch (XMLStreamException | FactoryConfigurationError e) {
			logger.fatal("Ошибка парсинга");
			e.printStackTrace();
		}

		return null;
	}
}
