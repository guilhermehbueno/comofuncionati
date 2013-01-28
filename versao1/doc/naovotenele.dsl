camadas:

br.com.naovote.domain - Ira armazenar as DSLs
br.com.naovote.domain.model - Irá armazenar as entidades

br.com.naovote.infra
br.com.naovote.infra.annotations
br.com.naovote.infra.dao - Irá encapsular o acesso a dados
br.com.naovote.infra.dao.query - Irá armazenar classes responsáveis por gerar as querys
br.com.naovote.infra.dao.data - Irá armazenar classes responsáveis por carregar em classes o resultado das consultas


NaoVoteTerms
	.oCandidato("NOME_CANDIDATO");
	.aNoticia("LINK_1");
	.oComentario("OBSERVACOES");

quero()
	.denunciar(oCandidato("NOME_CANDIDATO"))
	.com(aNoticia("LINK_1"), aNoticia("LINK_2", aNoticia("LINK_3"), aNoticia("LINK_4")))
	.e(observacao("OBSERVACOES"));
	
quero()
	.investigar(oCandidato("NOME_CANDIDATO"));
	
quero()
	.buscar(Candidato.class)
	.por(expression("NOME").equals("LULA").and(expression("PARTIDO").equals("PT")));
	
quero()
	.cadastrarOuAtualizar(candidato);
	
quero()
	.carregar(Noticias.class)
	.do(Candidato.class, candidato)
	.load();
	
NaoVoteQueryTransform
	.extractNumeroPartido(String expression);
	.extractCargo(String expression);
	.extractNumeroPartido(String expression);
	.extractNomeCandidato(String expression);
	
	
Candidato candidato = new Candidato();	
NaoVoteGenerateQueryReflection
	.getQueryByExample(candidato);
	.getInsertByExample(candidato)