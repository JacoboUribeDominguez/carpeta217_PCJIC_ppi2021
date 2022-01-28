describe("Interact with a route (like): ", function() {
  it("With an user: ", function() {
    cy.visit("http://localhost:8080/Login");
    cy.get(".user").type("jakopapafrita");
    cy.get(".password").type("123");
    cy.get(".btnInicioSesion").click();
    cy.get(":nth-child(2) > .publicacionDestacada > .ml-2 > .meGusta > .up > path").click();
  });


});