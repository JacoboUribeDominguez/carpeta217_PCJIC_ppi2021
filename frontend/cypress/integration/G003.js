describe("Creating a route: ", function() {
  it("With an user: ", function() {
    cy.visit("http://localhost:8080/Login");
    cy.get(".user").type("MadHacker");
    cy.get(".password").type("123");
    cy.get(".btnInicioSesion").click();
    cy.get(".mt-3 > .bi").click();
    cy.get("[placeholder=\"Ubicación inicial\"]").type("Inicio");
    cy.get(".row > .AddRouteContainer > .bodyAddRoute > .justify-content-center > [placeholder=\"Ubicación final\"]").type("Final");
    cy.get(".row > .AddRouteContainer > .bodyAddRoute > .flex-column > .my-4 > .btnUpload").click();
  });
  /*
  it("Without an user: ", function() {
    cy.visit("http://localhost:8080/");
    cy.get(".mt-3 > .bi").click();
    cy.get("[placeholder=\"Ubicación inicial\"]").type("Inicio");
    cy.get(".row > .AddRouteContainer > .bodyAddRoute > .justify-content-center > [placeholder=\"Ubicación final\"]").type("Final");
    cy.get(".row > .AddRouteContainer > .bodyAddRoute > .flex-column > .my-4 > .btnUpload").click();
  });
  */
   
});