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

public class GetCharacterStepDefinitions {

    private static final String URL_SERVICE = "https://rickandmortyapi.com/api/character";

    @Before
    public void InitialSetUp(){
        setTheStage(new OnlineCast());
    }


    @Given("^that user wants to consult a character$")
    public void that_user_wants_to_consult_a_character() {
        theActorCalled("User").whoCan(CallAnApi.at(URL_SERVICE));

    }

    @When("^he consults the API$")
    public void he_consults_the_API() {
        theActorInTheSpotlight().attemptsTo(Get.resource("/{character}").
                with(request -> request.pathParam("character", "2")));

    }

    @Then("^the response of the service shows the character information$")
    public void the_response_of_the_service_shows_the_character_information() {
        theActorInTheSpotlight().should(
                seeThatResponse(response -> response.statusCode(200)).orComplainWith(CommonExceptions.class,
                        CommonExceptions.STATUS_CODE_INCORRECT));
    }


}
