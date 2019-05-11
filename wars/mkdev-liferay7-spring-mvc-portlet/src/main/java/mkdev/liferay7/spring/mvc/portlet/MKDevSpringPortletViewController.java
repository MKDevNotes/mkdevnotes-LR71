package mkdev.liferay7.spring.mvc.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import mkdev.liferay7.spring.mvc.util.LiferayUrlUtil;

/**
 * @author Muthukumar
 */
@Controller
@RequestMapping("VIEW")
public class MKDevSpringPortletViewController {

	private Log LOGGER = LogFactoryUtil.getLog(MKDevSpringPortletViewController.class);
	@RenderMapping
	public String viewSpringPage(RenderRequest request, RenderResponse response) {
		LOGGER.info("#############################Calling viewHomePage##################################");
		return "view";
	}
	
	@ActionMapping(params = { "action=saveChanges" })
	public void bla(@ModelAttribute("user") User user, ModelMap model, ActionResponse response, ActionRequest request)
			throws Exception {
	//	service.sayHelloToTheLogs(user);
	}

	@RenderMapping(params = { "render=renderSample" })
	public String doRenderActionSample(Model m, PortletRequest portletRequest, PortletResponse portletResponse) {
		LOGGER.debug("renderSample called");

		return "templates/view";
	}


	@ResourceMapping("ajaxTest")
	public void doResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		LOGGER.debug("doResource called");

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("ajaxCallRes", "SUCCESS");

		OutputStream out = null;
		try {
			resourceResponse.setContentType("application/json");
			out = resourceResponse.getPortletOutputStream();
			StreamUtil.transfer(new ByteArrayInputStream(json.toString().getBytes("utf-8")), out);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
	}


	@ModelAttribute("themeDisplay")
	public ThemeDisplay getThemeDisplay(PortletRequest portletRequest) {
		return (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	}

	@ModelAttribute("saveChangesActionURL")
	public String getSampleActionURL(PortletRequest portletRequest, ThemeDisplay themeDisplay) {
		PortletURL actionSampleURL = LiferayUrlUtil.createActionURL(portletRequest, themeDisplay, LiferayWindowState.NORMAL, LiferayPortletMode.VIEW);
		actionSampleURL.setParameter("action", "saveChanges");
		return actionSampleURL.toString();
	}

	@ModelAttribute("sampleResourceURL")
	public String getSampleResourceURL(PortletResponse portletResponse) {
		ResourceURL sampleResourceURL = LiferayUrlUtil.createResourceURL("ajaxTest", portletResponse);
		return sampleResourceURL.toString();
	}
	
}