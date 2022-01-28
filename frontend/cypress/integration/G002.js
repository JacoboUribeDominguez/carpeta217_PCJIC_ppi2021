describe("Login test case: ", function() {
  it("Login: ", function() {
    cy.visit("http://localhost:8080/Login");
    cy.get(".user").type("MadHacker");
    cy.get(".password").type("123");
    cy.get(".btnInicioSesion").click();
  });
  it("Login failed: ", function() {
    cy.visit("http://localhost:8080/Login");
    cy.get(".user").type("MadHacker");
    cy.get(".password").type("123");
    cy.get(".btnInicioSesion").click();
  });
});