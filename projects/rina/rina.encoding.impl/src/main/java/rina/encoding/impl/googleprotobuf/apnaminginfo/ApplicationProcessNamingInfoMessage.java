// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protofiles/ApplicationProcessNamingInfoMessage.proto

package rina.encoding.impl.googleprotobuf.apnaminginfo;

public final class ApplicationProcessNamingInfoMessage {
  private ApplicationProcessNamingInfoMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class applicationEntityNamingInfo_t extends
      com.google.protobuf.GeneratedMessage {
    // Use applicationEntityNamingInfo_t.newBuilder() to construct.
    private applicationEntityNamingInfo_t() {
      initFields();
    }
    private applicationEntityNamingInfo_t(boolean noInit) {}
    
    private static final applicationEntityNamingInfo_t defaultInstance;
    public static applicationEntityNamingInfo_t getDefaultInstance() {
      return defaultInstance;
    }
    
    public applicationEntityNamingInfo_t getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.internal_static_rina_messages_applicationEntityNamingInfo_t_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.internal_static_rina_messages_applicationEntityNamingInfo_t_fieldAccessorTable;
    }
    
    // required string applicationEntityName = 1;
    public static final int APPLICATIONENTITYNAME_FIELD_NUMBER = 1;
    private boolean hasApplicationEntityName;
    private java.lang.String applicationEntityName_ = "";
    public boolean hasApplicationEntityName() { return hasApplicationEntityName; }
    public java.lang.String getApplicationEntityName() { return applicationEntityName_; }
    
    // optional string applicationEntityInstance = 2;
    public static final int APPLICATIONENTITYINSTANCE_FIELD_NUMBER = 2;
    private boolean hasApplicationEntityInstance;
    private java.lang.String applicationEntityInstance_ = "";
    public boolean hasApplicationEntityInstance() { return hasApplicationEntityInstance; }
    public java.lang.String getApplicationEntityInstance() { return applicationEntityInstance_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      if (!hasApplicationEntityName) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasApplicationEntityName()) {
        output.writeString(1, getApplicationEntityName());
      }
      if (hasApplicationEntityInstance()) {
        output.writeString(2, getApplicationEntityInstance());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasApplicationEntityName()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getApplicationEntityName());
      }
      if (hasApplicationEntityInstance()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(2, getApplicationEntityInstance());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t result;
      
      // Construct using rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t();
        return builder;
      }
      
      protected rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.getDescriptor();
      }
      
      public rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t getDefaultInstanceForType() {
        return rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t) {
          return mergeFrom((rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t other) {
        if (other == rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.getDefaultInstance()) return this;
        if (other.hasApplicationEntityName()) {
          setApplicationEntityName(other.getApplicationEntityName());
        }
        if (other.hasApplicationEntityInstance()) {
          setApplicationEntityInstance(other.getApplicationEntityInstance());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 10: {
              setApplicationEntityName(input.readString());
              break;
            }
            case 18: {
              setApplicationEntityInstance(input.readString());
              break;
            }
          }
        }
      }
      
      
      // required string applicationEntityName = 1;
      public boolean hasApplicationEntityName() {
        return result.hasApplicationEntityName();
      }
      public java.lang.String getApplicationEntityName() {
        return result.getApplicationEntityName();
      }
      public Builder setApplicationEntityName(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasApplicationEntityName = true;
        result.applicationEntityName_ = value;
        return this;
      }
      public Builder clearApplicationEntityName() {
        result.hasApplicationEntityName = false;
        result.applicationEntityName_ = getDefaultInstance().getApplicationEntityName();
        return this;
      }
      
      // optional string applicationEntityInstance = 2;
      public boolean hasApplicationEntityInstance() {
        return result.hasApplicationEntityInstance();
      }
      public java.lang.String getApplicationEntityInstance() {
        return result.getApplicationEntityInstance();
      }
      public Builder setApplicationEntityInstance(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasApplicationEntityInstance = true;
        result.applicationEntityInstance_ = value;
        return this;
      }
      public Builder clearApplicationEntityInstance() {
        result.hasApplicationEntityInstance = false;
        result.applicationEntityInstance_ = getDefaultInstance().getApplicationEntityInstance();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:rina.messages.applicationEntityNamingInfo_t)
    }
    
    static {
      defaultInstance = new applicationEntityNamingInfo_t(true);
      rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:rina.messages.applicationEntityNamingInfo_t)
  }
  
  public static final class applicationProcessNamingInfo_t extends
      com.google.protobuf.GeneratedMessage {
    // Use applicationProcessNamingInfo_t.newBuilder() to construct.
    private applicationProcessNamingInfo_t() {
      initFields();
    }
    private applicationProcessNamingInfo_t(boolean noInit) {}
    
    private static final applicationProcessNamingInfo_t defaultInstance;
    public static applicationProcessNamingInfo_t getDefaultInstance() {
      return defaultInstance;
    }
    
    public applicationProcessNamingInfo_t getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.internal_static_rina_messages_applicationProcessNamingInfo_t_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.internal_static_rina_messages_applicationProcessNamingInfo_t_fieldAccessorTable;
    }
    
    // required string applicationProcessName = 1;
    public static final int APPLICATIONPROCESSNAME_FIELD_NUMBER = 1;
    private boolean hasApplicationProcessName;
    private java.lang.String applicationProcessName_ = "";
    public boolean hasApplicationProcessName() { return hasApplicationProcessName; }
    public java.lang.String getApplicationProcessName() { return applicationProcessName_; }
    
    // optional string applicationProcessInstance = 2;
    public static final int APPLICATIONPROCESSINSTANCE_FIELD_NUMBER = 2;
    private boolean hasApplicationProcessInstance;
    private java.lang.String applicationProcessInstance_ = "";
    public boolean hasApplicationProcessInstance() { return hasApplicationProcessInstance; }
    public java.lang.String getApplicationProcessInstance() { return applicationProcessInstance_; }
    
    // repeated .rina.messages.applicationEntityNamingInfo_t applicationEntities = 3;
    public static final int APPLICATIONENTITIES_FIELD_NUMBER = 3;
    private java.util.List<rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t> applicationEntities_ =
      java.util.Collections.emptyList();
    public java.util.List<rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t> getApplicationEntitiesList() {
      return applicationEntities_;
    }
    public int getApplicationEntitiesCount() { return applicationEntities_.size(); }
    public rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t getApplicationEntities(int index) {
      return applicationEntities_.get(index);
    }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      if (!hasApplicationProcessName) return false;
      for (rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t element : getApplicationEntitiesList()) {
        if (!element.isInitialized()) return false;
      }
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasApplicationProcessName()) {
        output.writeString(1, getApplicationProcessName());
      }
      if (hasApplicationProcessInstance()) {
        output.writeString(2, getApplicationProcessInstance());
      }
      for (rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t element : getApplicationEntitiesList()) {
        output.writeMessage(3, element);
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasApplicationProcessName()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getApplicationProcessName());
      }
      if (hasApplicationProcessInstance()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(2, getApplicationProcessInstance());
      }
      for (rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t element : getApplicationEntitiesList()) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, element);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t result;
      
      // Construct using rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t();
        return builder;
      }
      
      protected rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t.getDescriptor();
      }
      
      public rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t getDefaultInstanceForType() {
        return rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        if (result.applicationEntities_ != java.util.Collections.EMPTY_LIST) {
          result.applicationEntities_ =
            java.util.Collections.unmodifiableList(result.applicationEntities_);
        }
        rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t) {
          return mergeFrom((rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t other) {
        if (other == rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t.getDefaultInstance()) return this;
        if (other.hasApplicationProcessName()) {
          setApplicationProcessName(other.getApplicationProcessName());
        }
        if (other.hasApplicationProcessInstance()) {
          setApplicationProcessInstance(other.getApplicationProcessInstance());
        }
        if (!other.applicationEntities_.isEmpty()) {
          if (result.applicationEntities_.isEmpty()) {
            result.applicationEntities_ = new java.util.ArrayList<rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t>();
          }
          result.applicationEntities_.addAll(other.applicationEntities_);
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 10: {
              setApplicationProcessName(input.readString());
              break;
            }
            case 18: {
              setApplicationProcessInstance(input.readString());
              break;
            }
            case 26: {
              rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.Builder subBuilder = rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.newBuilder();
              input.readMessage(subBuilder, extensionRegistry);
              addApplicationEntities(subBuilder.buildPartial());
              break;
            }
          }
        }
      }
      
      
      // required string applicationProcessName = 1;
      public boolean hasApplicationProcessName() {
        return result.hasApplicationProcessName();
      }
      public java.lang.String getApplicationProcessName() {
        return result.getApplicationProcessName();
      }
      public Builder setApplicationProcessName(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasApplicationProcessName = true;
        result.applicationProcessName_ = value;
        return this;
      }
      public Builder clearApplicationProcessName() {
        result.hasApplicationProcessName = false;
        result.applicationProcessName_ = getDefaultInstance().getApplicationProcessName();
        return this;
      }
      
      // optional string applicationProcessInstance = 2;
      public boolean hasApplicationProcessInstance() {
        return result.hasApplicationProcessInstance();
      }
      public java.lang.String getApplicationProcessInstance() {
        return result.getApplicationProcessInstance();
      }
      public Builder setApplicationProcessInstance(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasApplicationProcessInstance = true;
        result.applicationProcessInstance_ = value;
        return this;
      }
      public Builder clearApplicationProcessInstance() {
        result.hasApplicationProcessInstance = false;
        result.applicationProcessInstance_ = getDefaultInstance().getApplicationProcessInstance();
        return this;
      }
      
      // repeated .rina.messages.applicationEntityNamingInfo_t applicationEntities = 3;
      public java.util.List<rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t> getApplicationEntitiesList() {
        return java.util.Collections.unmodifiableList(result.applicationEntities_);
      }
      public int getApplicationEntitiesCount() {
        return result.getApplicationEntitiesCount();
      }
      public rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t getApplicationEntities(int index) {
        return result.getApplicationEntities(index);
      }
      public Builder setApplicationEntities(int index, rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t value) {
        if (value == null) {
          throw new NullPointerException();
        }
        result.applicationEntities_.set(index, value);
        return this;
      }
      public Builder setApplicationEntities(int index, rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.Builder builderForValue) {
        result.applicationEntities_.set(index, builderForValue.build());
        return this;
      }
      public Builder addApplicationEntities(rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t value) {
        if (value == null) {
          throw new NullPointerException();
        }
        if (result.applicationEntities_.isEmpty()) {
          result.applicationEntities_ = new java.util.ArrayList<rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t>();
        }
        result.applicationEntities_.add(value);
        return this;
      }
      public Builder addApplicationEntities(rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.Builder builderForValue) {
        if (result.applicationEntities_.isEmpty()) {
          result.applicationEntities_ = new java.util.ArrayList<rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t>();
        }
        result.applicationEntities_.add(builderForValue.build());
        return this;
      }
      public Builder addAllApplicationEntities(
          java.lang.Iterable<? extends rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t> values) {
        if (result.applicationEntities_.isEmpty()) {
          result.applicationEntities_ = new java.util.ArrayList<rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t>();
        }
        super.addAll(values, result.applicationEntities_);
        return this;
      }
      public Builder clearApplicationEntities() {
        result.applicationEntities_ = java.util.Collections.emptyList();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:rina.messages.applicationProcessNamingInfo_t)
    }
    
    static {
      defaultInstance = new applicationProcessNamingInfo_t(true);
      rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:rina.messages.applicationProcessNamingInfo_t)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_rina_messages_applicationEntityNamingInfo_t_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_rina_messages_applicationEntityNamingInfo_t_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_rina_messages_applicationProcessNamingInfo_t_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_rina_messages_applicationProcessNamingInfo_t_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n4protofiles/ApplicationProcessNamingInf" +
      "oMessage.proto\022\rrina.messages\"a\n\035applica" +
      "tionEntityNamingInfo_t\022\035\n\025applicationEnt" +
      "ityName\030\001 \002(\t\022!\n\031applicationEntityInstan" +
      "ce\030\002 \001(\t\"\257\001\n\036applicationProcessNamingInf" +
      "o_t\022\036\n\026applicationProcessName\030\001 \002(\t\022\"\n\032a" +
      "pplicationProcessInstance\030\002 \001(\t\022I\n\023appli" +
      "cationEntities\030\003 \003(\0132,.rina.messages.app" +
      "licationEntityNamingInfo_tB0\n.rina.encod" +
      "ing.impl.googleprotobuf.apnaminginfo"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_rina_messages_applicationEntityNamingInfo_t_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_rina_messages_applicationEntityNamingInfo_t_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_rina_messages_applicationEntityNamingInfo_t_descriptor,
              new java.lang.String[] { "ApplicationEntityName", "ApplicationEntityInstance", },
              rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.class,
              rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationEntityNamingInfo_t.Builder.class);
          internal_static_rina_messages_applicationProcessNamingInfo_t_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_rina_messages_applicationProcessNamingInfo_t_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_rina_messages_applicationProcessNamingInfo_t_descriptor,
              new java.lang.String[] { "ApplicationProcessName", "ApplicationProcessInstance", "ApplicationEntities", },
              rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t.class,
              rina.encoding.impl.googleprotobuf.apnaminginfo.ApplicationProcessNamingInfoMessage.applicationProcessNamingInfo_t.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}
