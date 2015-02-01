package com.xyincemp.resources;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.xyincemp.models.dto.PoIDto;
import com.xyincemp.service.PoIService;


@Path("/poi")
public class PoIResource {
	
	private PoIService poIService = new PoIService();
	
	@GET
	@Path("/listar")
	@Produces(MediaType.TEXT_XML)
	public List<PoIDto> getPois(){
		return poIService.listar();
	}
	
	
	@GET
	@Path("/listarPorProximidade")
	@Produces(MediaType.TEXT_XML)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<PoIDto> getPois(@QueryParam("x") int x,
								@QueryParam("y") int y,
								@QueryParam("distancia") BigDecimal distanciaMax){
		PoIDto poiDto = new PoIDto();
		poiDto.setCoorX(x);
		poiDto.setCoorY(y);
		poiDto.setDistanciaMax(distanciaMax);
		
		return poIService.listarPorProximidade(poiDto);
	}
	
	@POST 
	@Path("/salva")
	@Consumes(MediaType.TEXT_XML) 
	@Produces(MediaType.TEXT_PLAIN)
	public String salva(PoIDto poIDto){
		poIService.salva(poIDto);
		return poIDto.getNome() + " Adicionado com sucesso !";
	}
	
}
