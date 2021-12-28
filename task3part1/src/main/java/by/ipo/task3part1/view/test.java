package by.ipo.task3part1.view;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import by.ipo.task3part1.dao.DataOperator;
import by.ipo.task3part1.dao.Impl.DataOperatorImpl;
import by.ipo.task3part1.dao.exception.DAOException;
import by.ipo.task3part1.dao.factory.DAOFactory;

public class test {

	{
		try {
			System.out.println(this.getClass().getClassLoader().getResources("\\der.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws URISyntaxException {
		
		new qqqq().qqq();
		
		System.out.println();

	}
	
	

}
 class qqqq {
	
	public qqqq() {
		
	}
	
	
	public void qqq() throws URISyntaxException {
		DataOperator da = DAOFactory.getInstance().getDataOperator();
		try {
			System.out.println(da.readData(new File(this.getClass().getClassLoader().getResource("\\der.json").toURI()).toString()));
			System.out.println(new File(this.getClass().getClassLoader().getResource("\\der.json").toURI()).toString());
		} catch (DAOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}