package com.ficagna.addressApi.model.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class EnderecoSalvo extends ApplicationEvent {

        private final HttpServletResponse response;
        private final Long id;

        public EnderecoSalvo(Object source, HttpServletResponse response, Long id) {
            super(source);
            this.response = response;
            this.id = id;
        }

        public HttpServletResponse getResponse() {
            return response;
        }

        public Long getId() {
            return id;
        }
    }

