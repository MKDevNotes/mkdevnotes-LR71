package mkdev.liferay7.spring.mvc.portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * @author Muthukumar
 */
@Controller
@RequestMapping("VIEW")
public class MKDevSpringPortletViewController {

	private Log log = LogFactoryUtil.getLog(MKDevSpringPortletViewController.class);
	@RenderMapping
	public String viewSpringPage(RenderRequest request, RenderResponse response) {
		log.info("#############################Calling viewHomePage##################################");
		return "view";
	}
}