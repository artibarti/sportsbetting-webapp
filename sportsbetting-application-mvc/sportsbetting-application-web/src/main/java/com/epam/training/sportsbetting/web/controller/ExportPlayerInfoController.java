package com.epam.training.sportsbetting.web.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.sportsbetting.application.service.EventService;
import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.xml.ObjectFactory;
import com.epam.training.sportsbetting.domain.xml.PlayerInfo;
import com.epam.training.sportsbetting.domain.xml.PlayerInfo.SportEvents;
import com.epam.training.sportsbetting.web.dto.ExportConfigDto;
import com.epam.training.sportsbetting.web.service.UserService;

@Controller
public class ExportPlayerInfoController {

	@Autowired private UserService userService;
	@Autowired private EventService eventService;

	@RequestMapping(value = "/download/playerinfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	public void downloadPlayerInfo(ExportConfigDto exportConfig, HttpServletResponse response) throws JAXBException {
		
		response.setContentType("application/xml");
        response.setHeader("Content-Disposition", "attachment; filename=playerinfo.xml");

        PlayerInfo playerInfo = createPlayerInfo();

        final JAXBContext jaxbContext = JAXBContext.newInstance(PlayerInfo.class);
        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try {
        	marshaller.marshal(playerInfo, response.getOutputStream());
        	response.flushBuffer();        	
        } catch (JAXBException | IOException e) {
        	System.out.println("ooops" + e.getMessage());
        }
	}
	
	private PlayerInfo createPlayerInfo() {

		Player loggedInPlayer = userService.getLoggedInPlayer();

        ObjectFactory objectFactory = new ObjectFactory();
        PlayerInfo playerInfo = objectFactory.createPlayerInfo();
        playerInfo.setAccountNumber(Integer.toString(loggedInPlayer.getAccountNumber()));
        playerInfo.setBalance(loggedInPlayer.getBalance());
        playerInfo.setCurrency(loggedInPlayer.getCurrency().toString());
        playerInfo.setName(loggedInPlayer.getName());
        playerInfo.setId(loggedInPlayer.getId());

        try {
			playerInfo.setDateOfBirth(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString()));
		} catch (DatatypeConfigurationException e) {
        	System.out.println("ooops" + e.getMessage());
		}
        
        SportEvents sportEvents = objectFactory.createPlayerInfoSportEvents();
        playerInfo.setSportEvents(sportEvents);
        return playerInfo;
	}
}
