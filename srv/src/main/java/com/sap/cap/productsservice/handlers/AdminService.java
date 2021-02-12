package com.sap.cap.productsservice.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;

// Event handler classes have to implement the marker interface EventHandler and register themselves as Spring Beans (@Component). 
// The marker interface is important, because it enables the CAP Java runtime to identify these classes among all Spring Beans.

// The annotation @ServiceName specifies the default service name all event handler methods apply to. Here this is AdminService, 
// as this was also the name when defining the service in the CDS model.

// Event handler methods get an event-specific event context parameter, which provides access to the input parameters of the event and the 
// ability to set the result. For example, let’s look at the CdsCreateEventContext context parameter. The event we’re extending is the CREATE event. 
// The type of the context variable is specific to this extended CREATE event. The onCreate method returns void, as the result is set by running: context.setResult(…).

@Component
@ServiceName("AdminService")
public class AdminService implements EventHandler {

    private Map<Object, Map<String, Object>> products = new HashMap<>();
   
    //CDS Query Notation (CQN) is the common language in CAP to run queries against services. 
    // It can be used to talk to the services defined by your model, but also remote services, such as the database.

    @On(event = CdsService.EVENT_CREATE, entity = "AdminService.Products")
    public void onCreate(CdsCreateEventContext context) {
        context.getCqn().entries().forEach(e -> products.put(e.get("ID"), e));
        context.setResult(context.getCqn().entries());
    }

    // Event handler methods are registered with @On, @Before, or @After annotations. Every event, such as an entity creation,
    // runs through these three phases. Each phase has a slightly different semantic. You’ll learn more about these semantics in the subsequent tutorial.

    @On(event = CdsService.EVENT_READ, entity = "AdminService.Products")
    public void onRead(CdsReadEventContext context) {
        context.setResult(products.values());
    }

}