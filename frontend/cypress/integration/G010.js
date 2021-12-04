describe("Do a mark in a route: ", function() {
  it("With an user: ", function() {
    cy.visit("http://localhost:8080/Login");
    cy.get(".user").type("jakopapafrita");
    cy.get(".password").type("123");
    cy.get(".btnInicioSesion").click();
    cy.get("#btnShowAccount").click();
    cy.get(".menuAccount > :nth-child(1)").click();
    cy.get(".inputMetricaAgregarTiempo").type("12");
    cy.get(".ml-2").click();
    cy.get("[style=\"background: none; height: 100vh; position: absolute; top: 0px; width: 100%; z-index: 3;\"] > .d-flex > :nth-child(2) > button").click();
  });
});