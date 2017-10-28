package com.example.mockito;

import com.example.mockito.relay.ArticleCalculator;
import com.example.mockito.relay.ArticleDatabase;
import com.example.mockito.relay.ArticleListener;
import com.example.mockito.relay.ArticleManager;
import com.example.mockito.relay.UserProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

/**
 * description  @InjectMocks 注解的使用;
 *      所有使用@Mock的注解类都被注入到使用@InjectMocks的类中。
 *
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
public class MockitoInjectMocksTest extends BaseTestCase {
    @Mock
    private ArticleCalculator calculator;
    @Mock(name = "database") private ArticleDatabase dbMock; // note the mock name attribute
    @Spy
    private UserProvider userProvider = new UserProvider();

    @InjectMocks
    private ArticleManager manager;

    @Test
    public void shouldDoSomething() {
        manager.initiateArticle();
        dbMock.addListener(new ArticleListener());
        verify(dbMock).addListener(any(ArticleListener.class));
    }
}
