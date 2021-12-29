package test.ipo.task3part2.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import by.ipo.task3part2.bean.ArtExhibition;
import by.ipo.task3part2.service.exception.ServiceException;
import by.ipo.task3part2.service.impl.ExhibitionReaderImpl;

class ExhibitionReaderImplTest {

	@Test
	void testRead() throws ServiceException, URISyntaxException {
		ExhibitionReaderImpl er = new ExhibitionReaderImpl();
		ArtExhibition[] expected = new ArtExhibition[2];
		
		expected[0] = new ArtExhibition("22.12.2021");
		expected[0].addPicture("Несвиж. Замок", "Владимир Шарков");
		expected[0].addPicture("Мирский замок", "Владимир Шарков");
		expected[0].addPicture("Минск. Зимний день", "Владимир Шарков");
		expected[1] = new ArtExhibition("04.03.2022");
		expected[1].addPicture("Покров", "Василий Маркнянович");
		expected[1].addPicture("Троица старозаповетная", "Василий Маркнянович");
		expected[1].addPicture("Деисус", "Василий Маркнянович");
		
		assertArrayEquals(expected, 
							 er.read(new File(this.getClass().getClassLoader()
							 						.getResource("\\ArtExhibition.json")
							 						.toURI()).toString()),
					 		"Ошибка чтения файла");
	}
	
	@Test
	void testWrongRead() throws ServiceException, URISyntaxException {
		ExhibitionReaderImpl er = new ExhibitionReaderImpl();
		ArtExhibition[] expected = new ArtExhibition[2];
		
		expected[0] = new ArtExhibition("22.12.2021");
		expected[0].addPicture("Несвиж. Замок", "Владимир Шарков");
		expected[0].addPicture("Мирский замок", "Владимир Шарков");
		expected[0].addPicture("Минск. Зимний день", "Владимир Шарков");
		expected[1] = new ArtExhibition("04.03.2022");
		expected[1].addPicture("Покров", "Василий Маркнянович");
		expected[1].addPicture("Троица старозаповетная", "Василий Маркнянович");
		expected[1].addPicture("Деисус", "Василий Маркнянович");
		
		assertThrows(ServiceException.class, 
					() -> er.read(new File(this.getClass().getClassLoader()
								 						.getResource("\\WrongArtExhibition.json")
								 						.toURI()).toString()),
					"Должно выбрасывать ServiceException");
	}

}
