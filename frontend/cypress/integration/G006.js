describe("Interact with a route (comment): ", function() {
  it("With an user: ", function() {
    cy.visit("http://localhost:8080/Login");
    cy.get(".user").type("jakopapafrita");
    cy.get(".password").type("123");
    cy.get(".btnInicioSesion").click();
    cy.get(":nth-child(2) > .publicacionDestacada > .justify-content-center > #showBotonsRute").click();
    cy.get("[style=\"color: white; background: rgb(29, 178, 229); border-radius: 50%;\"]").click();
    cy.get(".inputComment").type("Increible ruta.");
    //cy.get('.justify-content-center > .d-flex > .bi').click();
  });
});