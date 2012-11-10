/*
 * Copyright (c) 2012 James Adams
 * All Rights Reserved
 */

function newField(formId,name) {
    fieldId = formId + ":field[" + name + "]";
    labelObj = $('<label/>');
    labelObj.append(name + " ");
    labelObj.attr('for',fieldId);
    fieldObj = $('<input type="text"/>');
    fieldObj.attr('id',nameInputId);
    fieldObj.appendTo(labelObj);
    return labelObj;
}

function newComponent(cmp_seq_val) {

    // Define IDs
    cmpId = "cmp" + parseInt(cmp_seq_val);
    formId = cmpId + ":form";
    nameInputId = formId + ":field[name]";

    // Construct DOM objects
    cmpObj = $('<section class="component"/>');
    cmpObj.attr('id',cmpId);
    formObj = $('<form/>');
    formObj.attr('id',formId);
    cmpTitleObj = $('<h2/>');
    cmpTitleObj.text('Generated Component');
    cmpTitleObj.appendTo(formObj);
    formObj.append(newField(formId,"id"));
    formObj.append(newField(formId,"name"));
    formObj.appendTo(cmpObj);

    return cmpObj;
}

$(document).ready(function() {

    function createElement(data) {
        var sval;
        var el;

        switch (data['tag']) {
            case 'text':
                el = data['text'];
                break;
            default:
                sval = '<' + data['tag'] + '/>';
                el = $(sval);
                if (data['id']) {
                    el.prop('id',data['id']);
                }
                if (data['class'].length > 0) {
                    el.prop('class',data['class'].join(' '));
                }
                if (data['href']) {
                    el.prop('href',data['href']);
                }
                $.each(data['children'], function(i,child) {
                    el.append(createElement(child));
                });
        }
        return el;
    }

    // Load Header
    $('input#loadHeader').click(function(event) {
        $.getJSON('svc/header/archsynthe', function(data) {
            el = '';
            if (data['type'] === 'element') {
                el = createElement(data);
            }
            el.replaceAll('header');
        });

        // Nav setup
        $('ul#nav_top li').each(function(index) {
            $(this).removeClass('active');
            $(this).click(function(event) {
                event.preventDefault();
                $('ul#nav_top li').each(function(){
                    $(this).removeClass('active');
                });
                $(this).addClass('active');
            });
            if (index == 0) {
                $(this).addClass('active');
            }
        });
    });

    // New Component
    $('input#loadComponents').click(function(event) {
        $.getJSON('svc/header/archsynthe', function(data) {
            var items = [];

            $.each(data, function(key, val) {
                if (Object.prototype.toString.call(val) === '[object Object]') {
                    var line = '<li id="' + key + '">';
                    line += '<ul>';
                    $.each(val, function(key2, val2) {
                        line += '<li id="' + key2 + '">' + val2 + '</li>'
                    });
                    line += '</ul>';
                    line += '</li>';
                    items.push(line);
                } else {
                    items.push('<li id="' + key + '">' + val + '</li>');
                }
            });

            $('<ul/>', {
                'class': 'my-new-list',
                html: items.join('')
            }).replaceAll('div#result');
        });
    });

    var cmp_seq = 1;
    $('form input#newComponent').click(function(){
        cmpObj = newComponent(cmp_seq++);
        $('article.container').append(cmpObj);
    });
});