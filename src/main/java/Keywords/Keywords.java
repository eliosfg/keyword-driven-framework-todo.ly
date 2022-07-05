package Keywords;

import api.APIManager;
import framework.Environment;
import io.restassured.response.Response;
import utils.LoggerManager;

public class Keywords {
    private static final LoggerManager logger = LoggerManager.getInstance();
    private static final Environment environment = Environment.getInstance();
    private static final APIManager apiManager = APIManager.getInstance();
    public Response sendBasicAuthenticationRequest() {
        logger.info("Sending Basic Authentication Request");
        apiManager.setCredentials(environment.getUserName(), environment.getPassword());

        return apiManager.get(environment.getIsAuthenticatedEndPoint());
    }
}