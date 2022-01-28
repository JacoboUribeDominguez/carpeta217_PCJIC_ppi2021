describe("Search a route: ", function() {
  it("Search: ", function() {
    cy.visit("http://localhost:8080/");
    cy.get(".inputBuscar").type("Estadio");
    cy.get(".btnBuscar").click();
  });
});