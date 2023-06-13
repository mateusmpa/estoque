package br.com.senac.resources;

import br.com.senac.entity.Depositos;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import java.util.List;
import java.util.ArrayList;

@Path("/estoque")
public class Resources {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
      return "Hello";
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/depositos")
  public List<Depositos> getDepositos() {
      List<Depositos> depositos = new ArrayList();

      Depositos deposito_a = new Depositos();
      Depositos deposito_b = new Depositos();

      deposito_a.setId("1");
      deposito_a.setNome("São Paulo");

      deposito_b.setId("2");
      deposito_b.setNome("Rio Grande do Sul");

      depositos.add(deposito_a);
      depositos.add(deposito_b);

      return depositos;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/depositos/{id}")
  public Depositos getDeposito(@PathParam("id") String id) {
      Depositos p = new Depositos();

      p.setId(id);
      p.setNome("Mateus");
      p.setMensagem("Jogar Diablo!!");

      return p;
  }

  @POST
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Path("/depositos")
  public Depositos postDeposito(Depositos r) {
    Depositos p = new Depositos();

    p.setId(r.getId());
    p.setNome(r.getNome());
    p.setMensagem("Registro efetuado com sucesso!");

    return p;
  }

  @PUT
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Path("/depositos/{id}")
  public Depositos putDeposito(@PathParam("id") String id, Depositos r) {
    Depositos p = new Depositos();

    p.setId(id);
    p.setNome(r.getNome());
    p.setMensagem("Registro atualizado com sucesso!");

    return p;
  }

  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/depositos/{id}")
  public Depositos deleteDeposito(@PathParam("id") String id) {
      Depositos p = new Depositos();

      p.setId(id);
      p.setNome("Mateus");
      p.setMensagem("Removido com Sucesso!!");

      return p;
  }
}
