package client;

import dto.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;


@Slf4j
@Component
public class ProductApiClient {
    private final String baseUrl;
    private final RestTemplate rest;

    public ProductApiClient(@Value("http://localhost:8081") String baseUrl) {
        this.baseUrl = baseUrl;
        this.rest = new RestTemplate();
    }

    public Product addProduct(Product product) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/products")
                .toUriString();

        return rest.postForObject(url, product, Product.class);
    }

    public List<Product> getAllProducts() {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/products")
                .toUriString();
        log.info("Getting all products: " + url);
        return rest.exchange(url, GET, new HttpEntity<>(null), new ParameterizedTypeReference<List<Product>>() {
        }).getBody();
    }

    public Product deleteProduct(String productId) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/products/")
                .path(productId)
                .toUriString();
        return rest.exchange (url, DELETE, new HttpEntity<>(null), Product.class).getBody();
    }

    public Optional<Product> getById(String productId) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/products/")
                .path(productId)
                .toUriString();
        try {
            return ofNullable(rest.getForObject(url, Product.class));
        } catch (HttpClientErrorException ex) {
            return empty();
        }
    }
}


