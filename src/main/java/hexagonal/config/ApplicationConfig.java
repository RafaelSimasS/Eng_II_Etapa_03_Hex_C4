package hexagonal.config;

import hexagonal.adapters.out.repositories.mapper.JogoMapper;
import hexagonal.adapters.out.repositories.mapper.JogoPlataformaMapper;
import hexagonal.adapters.out.repositories.mapper.PlataformaMapper;
import hexagonal.core.domain.service.LocacaoService;
import hexagonal.core.domain.usecase.CalcularCustoTotalLocacaoUseCase;
import hexagonal.core.domain.usecase.CriarLocacaoUseCase;
import hexagonal.core.domain.usecase.InserirJogoLocacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import hexagonal.ports.in.CalcularCustoTotalLocacaoInputPort;
import hexagonal.ports.in.CriarLocacaoInputPort;
import hexagonal.ports.in.InserirJogoLocacaoInputPort;
import hexagonal.ports.out.ClienteRepositoryPort;
import hexagonal.ports.out.JogoPlataformaRepositoryPort;
import hexagonal.ports.out.LocacaoRepositoryPort;

@Configuration
public class ApplicationConfig {

    @Bean
    public JogoPlataformaMapper jogoPlataformaMapper(JogoMapper jogoMapper,
                                                     PlataformaMapper plataformaMapper) {
        return new JogoPlataformaMapper(jogoMapper, plataformaMapper);
    }

    @Bean
    public JogoMapper jogoMapper(JogoPlataformaMapper jogoPlataformaMapper) {
        return new JogoMapper(jogoPlataformaMapper);
    }

    @Bean
    public PlataformaMapper plataformaMapper(JogoPlataformaMapper jogoPlataformaMapper) {
        return new PlataformaMapper(jogoPlataformaMapper);
    }

    @Bean
    public LocacaoService servicoDeLocacao(ClienteRepositoryPort clienteRepo,
                                           LocacaoRepositoryPort locacaoRepo,
                                           JogoPlataformaRepositoryPort jogoPlatRepo) {
        return new LocacaoService(clienteRepo, locacaoRepo, jogoPlatRepo);
    }

    @Bean
    public CriarLocacaoInputPort criarLocacaoUseCase(LocacaoService servico) {
        return new CriarLocacaoUseCase(servico);
    }

    @Bean
    public InserirJogoLocacaoInputPort inserirJogoLocacaoUseCase(LocacaoService servico) {
        return new InserirJogoLocacaoUseCase(servico);
    }

    @Bean
    public CalcularCustoTotalLocacaoInputPort calcularCustoTotalLocacaoUseCase(LocacaoService servico) {
        return new CalcularCustoTotalLocacaoUseCase(servico);
    }
}
