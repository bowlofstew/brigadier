package com.mojang.brigadier.context;

import com.mojang.brigadier.ImmutableStringReader;

import java.util.Objects;

public class StringRange {
    private final int start;
    private final int end;

    public StringRange(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String get(final ImmutableStringReader reader) {
        return reader.getString().substring(start, end);
    }

    public String get(final String string) {
        return string.substring(start, end);
    }

    public boolean isEmpty() {
        return start == end;
    }

    public int getLength() {
        return end - start;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StringRange)) {
            return false;
        }
        final StringRange that = (StringRange) o;
        return start == that.start && end == that.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "StringRange{" +
            "start=" + start +
            ", end=" + end +
            '}';
    }

}
