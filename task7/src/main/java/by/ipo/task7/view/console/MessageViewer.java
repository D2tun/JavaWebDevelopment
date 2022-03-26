package by.ipo.task7.view.console;

import java.util.List;
import java.util.Scanner;

import by.ipo.task7.bean.Order;

/**
 * This class provides method for providing information to user.
 * 
 * @author Pavel Isidovich
 *
 */
public class MessageViewer {

	private static MessageViewer instance;

	private MessageViewer() {

	}

	/**
	 * This method returns link on existing object of this class. If object
	 * doesn't exist, creates new object of this class.
	 * 
	 * @return <strong>instance</strong> of the object.
	 */
	public static MessageViewer getInstance() {
		if (instance == null) {
			instance = new MessageViewer();
		}
		return instance;
	}

	/**
	 * This method shows answer to user.
	 * 
	 * @param info - message
	 */
	public void showInfo(String info) {
		System.out.println(info);
	}

	/**
	 * This method prints matrix to console
	 * 
	 * @param orders - list of order-objects
	 */
	public void showOrderList(List<Order> orders) {
		StringBuilder answer = new StringBuilder("");

		for (int i = 0; i < orders.size(); ++i) {
			answer.append("Order:\ncreaion date "
					+ orders.get(i).getCreationDate() + "\npayment date"
					+ orders.get(i).getPaymentDate() + "\ntext: "
					+ orders.get(i).getContent() + "\nOrderer:\n	name: "
					+ orders.get(i).getClient().getUser().getName() + " "
					+ orders.get(i).getClient().getUser().getSurname()
					+ "\n	e-mail: "
					+ orders.get(i).getClient().getUser().getEmail()
					+ "\n	password: "
					+ orders.get(i).getClient().getUser().getPassword()
					+ "\n	role: "
					+ orders.get(i).getClient().getUser().getRole()
					+ "\n	registration date"
					+ orders.get(i).getClient().getUser().getRegistrationDate()
					+ "\n	corporation: "
					+ orders.get(i).getClient().getCorporation().getName()
					+ "\n		"
					+ orders.get(i).getClient().getCorporation()
							.getCorporationInfo()
					+ "\nCoach:\n	name: "
					+ orders.get(i).getCoach().getUser().getName() + " "
					+ orders.get(i).getCoach().getUser().getSurname()
					+ "\n	e-mail: "
					+ orders.get(i).getCoach().getUser().getEmail()
					+ "\n	password: "
					+ orders.get(i).getCoach().getUser().getPassword()
					+ "\n	role: "
					+ orders.get(i).getCoach().getUser().getRole()
					+ "\n	registration date"
					+ orders.get(i).getCoach().getUser().getRegistrationDate()
					+ "\n	" + orders.get(i).getCoach().getCoachInfo()
					+ "\nsubscription:\n	quantity of trainings: "
					+ orders.get(i).getSubscription().getTrainingsQuantity()
					+ "\n	payment date: "
					+ orders.get(i).getSubscription().getPaymentDate()
					+ "\n	expire date: "
					+ orders.get(i).getSubscription().getExpireDate());

			for (int j = 0; j < orders.get(i).getAppointmentQuantity(); ++j) {
				answer.append(
						"\nappointment:"
								+ orders.get(i).getAppointment(j).getContent()
								+ "\n	rating: "
								+ orders.get(i).getAppointment(j).getRating()
								+ "\n	comment: "
								+ orders.get(i).getAppointment(j).getComment()
								+ "\n	creation date: "
								+ orders.get(i).getAppointment(j)
										.getCreationDate()
								+ "\n	status: "
								+ orders.get(i).getAppointment(j).getStatus());
			}
		}

		System.out.println(answer.toString());
	}

	/**
	 * This method requests information from user.
	 * 
	 * @param message - information request
	 * @return string, entered by user
	 */
	public String dataRequest(String message) {
		Scanner sc = new Scanner(System.in);

		System.out.println(message);

		return sc.nextLine();
	}
}