/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

package com.archsynthe.service.rs;

import com.archsynthe.model.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Map;

/**
 * The HeaderResource class ...
 *
 * @author James Adams
 * @version 1.0.0
 * @since 1.0.0
 */
@Path("/header")
public class HeaderResource {

	private Map<String, HeaderElement> clientHeaderMap = new HashMap<String, HeaderElement>();

	public HeaderResource() {
		final String clientId = "archsynthe";

		// Create <header>
		HeaderElement headerElement = new HeaderElement();
		headerElement.setId("banner");
		headerElement.addClass("Body");

		// Create <h1>
		H1Element h1Element = new H1Element();
		AnchorElement anchorElement = new AnchorElement();
		anchorElement.setHref("#");
		anchorElement.append(new TextElement("Archsynthe"));
		h1Element.append(anchorElement);

		// Create <nav>
		NavElement navElement = new NavElement();
		UlElement ulElement = new UlElement();
		ulElement.setId("nav_top");

		LiElement navHomeLi = new LiElement();
		navHomeLi.setId("nav_home");
		AnchorElement navHomeAnchor = new AnchorElement();
		navHomeAnchor.setHref("#");
		navHomeAnchor.append(new TextElement("home"));
		navHomeLi.append(navHomeAnchor);
		ulElement.append(navHomeLi);

		LiElement navComponentsLi = new LiElement();
		navComponentsLi.setId("nav_components");
		AnchorElement navComponentsAnchor = new AnchorElement();
		navComponentsAnchor.setHref("#");
		navComponentsAnchor.append(new TextElement("components"));
		navComponentsLi.append(navComponentsAnchor);
		ulElement.append(navComponentsLi);

		LiElement navDocumentationLi = new LiElement();
		navDocumentationLi.setId("nav_documentation");
		AnchorElement navDocAnchor = new AnchorElement();
		navDocAnchor.setHref("#");
		navDocAnchor.append(new TextElement("documentation"));
		navDocumentationLi.append(navDocAnchor);
		ulElement.append(navDocumentationLi);

		navElement.append(ulElement);

		headerElement.append(h1Element);
		headerElement.append(navElement);

		clientHeaderMap.put(clientId, headerElement);
	}

	@GET
	@Path("/{clientId}")
	@Produces("application/json")
	public HeaderElement getClientHeader(@PathParam("clientId") String clientId) {
		return clientHeaderMap.get(clientId);
	}

}
