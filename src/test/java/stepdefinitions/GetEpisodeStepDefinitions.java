package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.CommonExceptions;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetEpisodeStepDefinitions {

    private static final String URL_SERVICE = "https://rickandmortyapi.com/api/episode";

    @Before
    public void InitialSetUp(){
        setTheStage(new OnlineCast());
    }


    @Given("^that user wants to consult a episode$")
    public void that_user_wants_to_consult_a_episode() {
        theActorCalled("User").whoCan(CallAnApi.at(URL_SERVICE));
    }


    @When("^he consults the episode$")
    public void he_consults_the_episode() {
        theActorInTheSpotlight().attemptsTo(Get.resource("/{episode}").
                with(request -> request.pathParam("episode", "28")));

    }

    @Then("^the response of the service shows the episode information$")
    public void the_response_of_the_service_shows_the_episode_information() {
        theActorInTheSpotlight().should(
                seeThatResponse(response -> response.statusCode(200)).orComplainWith(CommonExceptions.class,
                        CommonExceptions.STATUS_CODE_INCORRECT));

    }

}
