package mkdev.liferay7.spring.mvc.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class LiferayUtil {

    private static final Log LOGGER = LogFactory.getLog(LiferayUtil.class);
	
	private LiferayUtil() {
		throw new AssertionError();
	}
	
	/*public static User getCurrentUser(PortletRequest request) {
		
		try {
			com.liferay.portal.kernel.model.User lrUser = PortalUtil.getUser(request);

			User user = new User();
			if (lrUser != null) {
				user.setFirstName(lrUser.getFirstName());
				user.setLastName(lrUser.getLastName());
				user.setEmail(lrUser.getEmailAddress());
			} else {
				user.setFirstName("anonymous");
			}
			return user;
			
		} catch (PortalException e) {
			LOGGER.error("error retreiving Liferay user");
			return null;
		}
	}*/
}
