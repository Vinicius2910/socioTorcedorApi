/**
 * 
 */
package com.br.avaliacao.socioTorcedorApi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.avaliacao.socioTorcedorApi.client.valueobject.CampanhaVO;

/**
 * @author Vinicius
 *
 */

@FeignClient(url="http://localhost:8080", name = "campanha")
public interface CampanhaClient {

	@RequestMapping(method= RequestMethod.GET, value = "/campanhas")
	List<CampanhaVO> listar();
	
}
